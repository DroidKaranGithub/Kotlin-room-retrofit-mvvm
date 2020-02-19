package com.example.kotlintesting.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlintesting.mvvm.model.UserResponseModel
import com.example.kotlintesting.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    lateinit var userMutableLiveData: MutableLiveData<UserResponseModel>

    companion object {

        fun getInstance(): MainRepository {
            return MainRepository()
        }
    }

    fun requestGetUser(page: String) {
        var call = ApiService.apiInterface.responseGetUser(page)
        call.enqueue(object : Callback<UserResponseModel> {
            override fun onFailure(call: Call<UserResponseModel>, t: Throwable) {
                userMutableLiveData.value=null
            }
            override fun onResponse(
                call: Call<UserResponseModel>, response: Response<UserResponseModel>
            ) {
                userMutableLiveData.value=response.body()
            }
        })
    }

    fun responseGetUser(): MutableLiveData<UserResponseModel> {
        userMutableLiveData = MutableLiveData()
        return userMutableLiveData
    }
}