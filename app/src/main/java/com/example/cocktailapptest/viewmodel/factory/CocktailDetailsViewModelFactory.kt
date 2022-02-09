package com.example.cocktailapptest.viewmodel.factory

import androidx.lifecycle.ViewModel
import com.example.cocktailapptest.domain.GetCocktailByIdUseCase
import com.example.cocktailapptest.domain.SaveOrRemoveFromFavouriteUseCase
import com.example.cocktailapptest.viewmodel.CocktailDetailsViewModel

class CocktailDetailsViewModelFactory(
    private val id: String
) : MainViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CocktailDetailsViewModel(
            GetCocktailByIdUseCase(repository),
            SaveOrRemoveFromFavouriteUseCase(repository),
            id = id
        ) as T
    }
}