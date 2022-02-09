package com.example.cocktailapptest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapptest.domain.GetSavedCocktailsUseCase
import com.example.cocktailapptest.model.remote.response.Cocktail
import kotlinx.coroutines.launch

class SavedCocktailsViewModel(
    private val getSavedCocktailsUseCase: GetSavedCocktailsUseCase
) : ViewModel() {

    private val _getSavedCocktails = MutableLiveData<List<Cocktail>>()
    val getSavedCocktails: LiveData<List<Cocktail>>
        get() = _getSavedCocktails

    init {
        viewModelScope.launch {
            _getSavedCocktails.value = getSavedCocktailsUseCase()!!
        }
    }
}