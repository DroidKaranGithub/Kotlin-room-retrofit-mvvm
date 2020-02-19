package com.example.kotlintesting.mvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlintesting.mvvm.model.UserResponseModel
import com.example.kotlintesting.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var mainRepository = MainRepository.getInstance()

    fun requestGetUser(page: String) {
        mainRepository.requestGetUser(page)
    }

    fun responseGetUser(): MutableLiveData<UserResponseModel> {
        return mainRepository.responseGetUser()
    }

}