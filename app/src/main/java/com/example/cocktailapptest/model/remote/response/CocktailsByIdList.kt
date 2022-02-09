package com.example.cocktailapptest.model.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class CocktailsByIdList(
    @SerializedName("drinks")
    @Expose
    val drinks: List<Cocktail>
)

@Entity(tableName = "saved_cocktails_entity")
class Cocktail(
    @SerializedName("idDrink")
    @Expose
    @PrimaryKey
    val idCocktail: String,
    @SerializedName("strDrink")
    @Expose
    val cocktailName: String,
    @SerializedName("strInstructions")
    @Expose
    val cocktailInstruction: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val image: String
)