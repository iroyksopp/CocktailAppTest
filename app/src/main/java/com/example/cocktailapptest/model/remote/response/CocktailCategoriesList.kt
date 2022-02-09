package com.example.cocktailapptest.model.remote.response


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailCategoriesList(
    @SerializedName("drinks")
    @Expose
    val drinks: List<Drink>
)

data class Drink(
    @SerializedName("strCategory")
    @Expose
    val category: String
)