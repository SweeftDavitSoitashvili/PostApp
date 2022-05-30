package com.example.postsapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class RetrofitClient {

    fun getRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}