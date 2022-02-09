package com.example.cocktailapptest.model

import android.util.Log
import com.example.cocktailapptest.model.local.CocktailDao
import com.example.cocktailapptest.model.remote.Api
import com.example.cocktailapptest.model.remote.response.CocktailByCategory
import com.example.cocktailapptest.model.remote.response.Cocktail
import com.example.cocktailapptest.model.remote.response.Drink
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val api: Api,
    private val dao: CocktailDao,
    private val ioDispatcher: CoroutineDispatcher
) : Repository {
    override suspend fun getCocktailCategories(): List<Drink> {
       return withContext(ioDispatcher) {
            val response = api.getCategories()
            response.drinks
//            response.drinks.let {
//                dao.insertAllCategories(it)
//            }
        }
    }

    override suspend fun getCocktailsByCategory(category: String): List<CocktailByCategory> {
       return withContext(ioDispatcher) {
            val response = api.getCocktailsByCategory(category)
            response.drinks
        }
    }

    override suspend fun getCocktailsById(id: String): Cocktail {
        return withContext(ioDispatcher) {
            val response = api.getCocktailById(id)
            response.drinks.first()
        }
    }

    override suspend fun saveOrRemoveFromFavourite(cocktail: Cocktail) {
        withContext(ioDispatcher) {
            val isCocktailFavouriteId = dao.getCocktailById(cocktail.idCocktail)
            if(isCocktailFavouriteId == null) {
                dao.insertCocktail(cocktail)
                Log.d("SAVE_REMOVE", "ADDED")
            } else {
                dao.deleteCocktail(isCocktailFavouriteId)
                Log.d("SAVE_REMOVE", "REMOVED")
            }
        }
    }

    override suspend fun getSavedCocktails(): List<Cocktail> {
        return withContext(ioDispatcher) {
            dao.getAllSavedCocktails()
        }
    }

}