package com.example.cocktailapptest.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailapptest.domain.GetCocktailCategoriesUseCase
import com.example.cocktailapptest.domain.GetSavedCocktailsUseCase
import com.example.cocktailapptest.model.Repository
import com.example.cocktailapptest.model.RepositoryFactory
import com.example.cocktailapptest.viewmodel.MainViewModel
import com.example.cocktailapptest.viewmodel.SavedCocktailsViewModel

open class MainViewModelFactory(
    protected val repository: Repository = RepositoryFactory.repository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> {
                MainViewModel(
                    GetCocktailCategoriesUseCase(repository)
                ) as T
            }
            SavedCocktailsViewModel::class.java -> {
                SavedCocktailsViewModel(
                    GetSavedCocktailsUseCase(repository)
                ) as T
            }
            else -> super.create(modelClass)
        }
    }
}