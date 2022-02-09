package com.example.cocktailapptest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapptest.domain.GetCocktailCategoriesUseCase
import com.example.cocktailapptest.model.local.DbFactory
import com.example.cocktailapptest.model.remote.response.Drink
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCocktailCategoriesUseCase: GetCocktailCategoriesUseCase
) : ViewModel() {

    private val _getCocktailCategories = MutableLiveData<List<Drink>>()
    val getCocktailCategories: LiveData<List<Drink>>
        get() = _getCocktailCategories

    init {
        getCocktailCategories()
    }

    private fun getCocktailCategories() {
        viewModelScope.launch {
            _getCocktailCategories.value = getCocktailCategoriesUseCase()!!
        }
    }
}