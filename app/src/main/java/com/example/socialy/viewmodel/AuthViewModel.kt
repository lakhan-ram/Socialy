package com.example.socialy.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.socialy.model.repositories.AuthRepository

class AuthViewModel(context: Context) : ViewModel() {
    private val authRepository = AuthRepository(context)
    val authList = authRepository.authList

    fun signUp(name: String, email: String, password: String) {
        authRepository.signUp(name, email, password)
    }

    fun signIn(email: String, password: String) {
        authRepository.signIn(email, password)
    }
}