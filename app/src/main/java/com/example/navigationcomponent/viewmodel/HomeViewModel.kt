package com.example.navigationcomponent.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var email= MutableLiveData<String>()
    private var password= MutableLiveData<String>()

    fun getEmail(): LiveData<String> {
        return email
    }

    fun setEmail(em: String) {
        this.email.value = em
    }


    fun getPassword(): LiveData<String> {
        return password
    }

    fun setPassword(pwd: String) {
        this.password.value = pwd
    }
}