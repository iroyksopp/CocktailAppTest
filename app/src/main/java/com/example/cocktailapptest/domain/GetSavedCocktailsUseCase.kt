package com.example.cocktailapptest.domain

import com.example.cocktailapptest.model.Repository
import com.example.cocktailapptest.model.remote.response.Cocktail

class GetSavedCocktailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Cocktail> {
        return repository.getSavedCocktails()
    }
}