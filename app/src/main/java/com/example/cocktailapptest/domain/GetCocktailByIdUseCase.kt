package com.example.cocktailapptest.domain

import com.example.cocktailapptest.model.Repository
import com.example.cocktailapptest.model.remote.response.Cocktail

class GetCocktailByIdUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: String): Cocktail {
        return repository.getCocktailsById(id)
    }
}