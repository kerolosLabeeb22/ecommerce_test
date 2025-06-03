package com.example.ecommercetest.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {
    val email= mutableStateOf("")
    val emailError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val password = mutableStateOf("")



    fun login(){
        if (isFormedFieldValid()){

        }
    }

    private fun isFormedFieldValid(): Boolean {
       if (email.value.isEmpty() || email.value.isBlank()){
           emailError.value="Email is required"
           return false
       }else{
           emailError.value=null
       }

        if (password.value.isEmpty() || password.value.isBlank()){
            passwordError.value="Password is required"
            return false
        }else{
            passwordError.value=null
        }
        return true
    }
}