package com.raywenderlich.shopapiloginscreen.network

import com.raywenderlich.model.Auth
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @POST("/login")
    suspend fun userAuth(@Query("email")email:String,@Query("password")password:String):Response<Auth>


}