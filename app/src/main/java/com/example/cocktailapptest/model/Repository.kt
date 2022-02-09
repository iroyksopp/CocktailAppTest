package com.example.cocktailapptest.model

import com.example.cocktailapptest.model.remote.response.CocktailByCategory
import com.example.cocktailapptest.model.remote.response.Cocktail
import com.example.cocktailapptest.model.remote.response.Drink

interface Repository {

    suspend fun getCocktailCategories(): List<Drink>

    suspend fun getCocktailsByCategory(category: String): List<CocktailByCategory>

    suspend fun getCocktailsById(id: String): Cocktail

    suspend fun saveOrRemoveFromFavourite(cocktail: Cocktail)

    suspend fun getSavedCocktails(): List<Cocktail>
}