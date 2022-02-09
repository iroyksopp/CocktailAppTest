package com.example.cocktailapptest.model.remote.response

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CocktailsByCategoryList(
    @SerializedName("drinks")
    @Expose
    val drinks: List<CocktailByCategory>
)

data class CocktailByCategory(
    @SerializedName("strDrink")
    @Expose
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val strDrinkThumb: String,
    @PrimaryKey
    @SerializedName("idDrink")
    @Expose
    val idDrink: String
)
