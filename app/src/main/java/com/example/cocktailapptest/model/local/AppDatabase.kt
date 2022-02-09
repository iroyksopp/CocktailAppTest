package com.example.cocktailapptest.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktailapptest.model.remote.response.Cocktail

@Database(entities = [Cocktail::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}