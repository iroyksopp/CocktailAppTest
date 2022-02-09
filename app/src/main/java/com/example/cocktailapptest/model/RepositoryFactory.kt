package com.example.cocktailapptest.model

import com.example.cocktailapptest.model.local.DbFactory
import com.example.cocktailapptest.model.remote.ApiFactory
import kotlinx.coroutines.Dispatchers

object RepositoryFactory {
    val repository: Repository by lazy {
        RepositoryImpl(ApiFactory.api, DbFactory.dao, Dispatchers.IO)
    }
}