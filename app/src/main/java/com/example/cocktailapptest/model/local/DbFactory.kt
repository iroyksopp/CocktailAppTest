package com.example.cocktailapptest.model.local

import android.content.Context
import androidx.room.Room

object DbFactory {
    lateinit var db: AppDatabase

    fun init(applicationContext: Context) {
        if (!this::db.isInitialized) {
            db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-cocktail"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    val dao: CocktailDao by lazy {
        db.cocktailDao()
    }
}