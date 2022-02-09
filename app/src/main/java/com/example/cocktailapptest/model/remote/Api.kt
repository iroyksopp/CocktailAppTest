package com.example.cocktailapptest.model.remote

import com.example.cocktailapptest.model.remote.response.CocktailCategoriesList
import com.example.cocktailapptest.model.remote.response.CocktailsByCategoryList
import com.example.cocktailapptest.model.remote.response.CocktailsByIdList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("list.php?c=list")
    suspend fun getCategories(): CocktailCategoriesList

    @GET("filter.php")
    suspend fun getCocktailsByCategory(
        @Query("c") category: String
    ): CocktailsByCategoryList

    @GET("lookup.php")
    suspend fun getCocktailById(
        @Query("i") id: String
    ): CocktailsByIdList

}