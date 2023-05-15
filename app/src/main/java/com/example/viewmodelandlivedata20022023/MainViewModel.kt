package com.example.viewmodelandlivedata20022023

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlin.random.Random

/**
 * Created by pphat on 5/15/2023.
 */
class MainViewModel(
    var authenticationRepository: AuthenticationRepository
): ViewModel() {
    private var mutableLiveDataUser: MutableLiveData<Triple<String, String, Boolean>> = MutableLiveData()
    private var mutableLiveDataMessage: MutableLiveData<String> = MutableLiveData()

    fun getLiveDataMessage(): LiveData<String> = mutableLiveDataMessage
    fun getLiveDataUser(): LiveData<Triple<String, String, Boolean>> = mutableLiveDataUser

    fun login(
        email: String,
        password: String,
        isSaved: Boolean
    ) {
        val message = when(authenticationRepository.login(email, password, isSaved)) {
            true -> "Đăng nhập thành công"
            else -> "Đăng nhâp thất bại!!!"
        }
        mutableLiveDataMessage.value = message
    }

    fun getDataUser() {
        authenticationRepository.getUser()?.let {
            mutableLiveDataUser.value = it
        }
    }
}
