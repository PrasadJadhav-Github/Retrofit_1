package com.example.retrofit_1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("posts")
    fun getPosts() : Call<PostResponse>

    object RetrofitInstance {
        private const val BASE_URL = "https://dummyjson.com/"

        val api : ApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

}