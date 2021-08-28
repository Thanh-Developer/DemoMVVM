package com.demo.mvvm.viewmodel

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.demo.mvvm.model.User

/**
 *  Create by ThanhPQ
 */
class LoginViewModel : ViewModel(), LifecycleObserver {
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    val isLoginSuccess = MutableLiveData<Boolean>().apply { value = false }

    private fun handleLogin(user: User) {
        // Handle logical data with remote data or local data
        isLoginSuccess.value = true
    }

    private fun validate(username: String, password: String): Boolean {
        var validated = true
        if (username.isEmpty() || password.isEmpty()) {
            validated = false
        }
        return validated
    }

    fun onLogin() {
        if (!validate(username.value.toString(), password.value.toString())) return
        handleLogin(User(username.value.toString(), password.value.toString()))
    }
}