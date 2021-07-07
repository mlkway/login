package com.raywenderlich.repo

import com.raywenderlich.model.Auth
import com.raywenderlich.network.ApiService
import com.raywenderlich.network.UserService
import com.raywenderlich.usecases.Resource
import com.raywenderlich.usecases.ResponseHandler
import retrofit2.Response
import java.lang.Exception

interface UserRepository {

 /*   private val userService: UserService by lazy { ApiService.apiService }
    private val responseHandler: ResponseHandler by lazy { ResponseHandler() }*/


    abstract suspend fun getUser(email:String,password:String):Resource<Auth>




}