package com.example.cocktailapptest.model.local


import androidx.room.*
import com.example.cocktailapptest.model.remote.response.Cocktail

@Dao
interface CocktailDao {

    @Query("SELECT * FROM saved_cocktails_entity")
    fun getAllSavedCocktails(): List<Cocktail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktail(cocktail: Cocktail)

    @Query("SELECT * FROM saved_cocktails_entity WHERE idCocktail == :id limit 1")
    suspend fun getCocktailById(id: String): Cocktail?

    @Delete
    suspend fun deleteCocktail(cocktail: Cocktail)
}