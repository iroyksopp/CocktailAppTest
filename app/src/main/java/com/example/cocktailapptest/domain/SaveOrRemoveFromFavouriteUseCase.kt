package com.example.cocktailapptest.domain

import com.example.cocktailapptest.model.Repository
import com.example.cocktailapptest.model.remote.response.Cocktail

class SaveOrRemoveFromFavouriteUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(cocktail: Cocktail) {
        repository.saveOrRemoveFromFavourite(cocktail)
    }
}