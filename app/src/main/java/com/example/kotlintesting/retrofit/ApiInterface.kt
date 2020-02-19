package com.example.kotlintesting.retrofit

import com.example.kotlintesting.mvvm.model.UserResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("users")
    fun responseGetUser(@Query("page") page: String): Call<UserResponseModel>
}