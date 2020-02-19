package com.example.kotlintesting.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {


    companion object {
      private  var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        private var okhttpclient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()
        private  var retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://reqres.in/api/").client(okhttpclient).build()
        var apiInterface= retrofit.create(ApiInterface::class.java)
    }
}