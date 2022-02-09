package com.example.cocktailapptest.domain

import com.example.cocktailapptest.model.Repository
import com.example.cocktailapptest.model.remote.response.CocktailByCategory

class GetCocktailsByCategoryUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(category: String): List<CocktailByCategory> {
       return repository.getCocktailsByCategory(category)
    }
}