package com.raywenderlich.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.model.Auth
import com.raywenderlich.network.ApiService
import com.raywenderlich.repo.UserRepository
import com.raywenderlich.usecases.Resource
import com.raywenderlich.usecases.ResponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    private var _userLiveData = MutableLiveData<Resource<Auth>>()

    val userLiveData: LiveData<Resource<Auth>> get() = _userLiveData


    fun login(email:String,password:String) {

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = userRepository.getUser(email,password)
                _userLiveData.postValue(result)
            }
        }
    }



}