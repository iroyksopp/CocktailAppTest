package com.example.cocktailapptest

import android.app.Application
import com.example.cocktailapptest.model.local.DbFactory

class CocktailApp : Application() {

    override fun onCreate() {
        DbFactory.init(this.applicationContext)
        super.onCreate()
    }
}