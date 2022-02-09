package com.example.cocktailapptest.domain

import com.example.cocktailapptest.model.Repository
import com.example.cocktailapptest.model.remote.response.Drink

class GetCocktailCategoriesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Drink> {
       return repository.getCocktailCategories()
    }
}