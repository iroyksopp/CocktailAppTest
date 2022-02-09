package com.example.cocktailapptest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapptest.domain.GetCocktailsByCategoryUseCase
import com.example.cocktailapptest.model.remote.response.CocktailByCategory
import kotlinx.coroutines.launch

class CocktailsViewModel(
    private val getCocktailsByCategoryUseCase: GetCocktailsByCategoryUseCase,
    private val category: String
) : ViewModel() {

    private val _getCocktailsByCategory = MutableLiveData<List<CocktailByCategory>>()
    val getCocktailsByCategory: LiveData<List<CocktailByCategory>>
        get() = _getCocktailsByCategory

    init {
        viewModelScope.launch {
            _getCocktailsByCategory.value = getCocktailsByCategoryUseCase(category)!!
        }
    }
}

