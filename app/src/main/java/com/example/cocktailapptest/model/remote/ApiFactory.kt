package com.example.cocktailapptest.model.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(
            OkHttpClient().newBuilder()
                .build()
        )
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val api: Api by lazy { retrofit().create(Api::class.java) }
}