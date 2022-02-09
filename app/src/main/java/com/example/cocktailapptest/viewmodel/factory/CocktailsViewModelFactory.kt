package com.example.cocktailapptest.viewmodel.factory

import androidx.lifecycle.ViewModel
import com.example.cocktailapptest.domain.GetCocktailsByCategoryUseCase
import com.example.cocktailapptest.viewmodel.CocktailsViewModel

class CocktailsViewModelFactory(
    private val category: String
) : MainViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CocktailsViewModel(
            GetCocktailsByCategoryUseCase(repository),
            category = category
        ) as T
    }
}