package com.raywenderlich.shopapiloginscreen

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.model.Auth
import com.raywenderlich.shopapiloginscreen.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.StringBuilder

class AuthViewModel:ViewModel() {






    fun login(email:String,password:String)= viewModelScope.launch {

        val response = withContext(Dispatchers.IO){
            ApiService.apiService.userAuth(
                email = email,
                password = password
            )
        }


    }



}