package com.example.cocktailapptest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapptest.domain.GetCocktailByIdUseCase
import com.example.cocktailapptest.domain.SaveOrRemoveFromFavouriteUseCase
import com.example.cocktailapptest.model.remote.response.Cocktail
import kotlinx.coroutines.launch

class CocktailDetailsViewModel(
    private val getCocktailByIdUseCase: GetCocktailByIdUseCase,
    private val saveOrRemoveFromFavouriteUseCase: SaveOrRemoveFromFavouriteUseCase,
    private val id: String
) : ViewModel() {

    private val _getCocktailById = MutableLiveData<Cocktail>()
    val getCocktailById: LiveData<Cocktail>
        get() = _getCocktailById

    init {
        viewModelScope.launch {
            _getCocktailById.value = getCocktailByIdUseCase(id)!!
        }
    }

    fun saveCocktail() {
        viewModelScope.launch {
            _getCocktailById.value.let {
                if (it != null) {
                    saveOrRemoveFromFavouriteUseCase(it)
                }
            }
        }
    }
}