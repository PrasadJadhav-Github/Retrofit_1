package com.example.retrofit_1

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.net.HttpURLConnection
import java.net.URL

interface UsersService {

    //this is a comment
    @GET("api/users/{user_id}")
    suspend fun fetchUsers(
        @Path("user_id") id : Int
    ) : UserModel

    companion object {
        fun getInstance() : UsersService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val usersService = retrofit.create(UsersService::class.java)
            return usersService
        }
    }
}