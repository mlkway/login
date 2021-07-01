package com.raywenderlich.shopapiloginscreen.network

import com.raywenderlich.model.Auth
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @POST("/login")
    @FormUrlEncoded
    suspend fun userAuth(@Field("email")email:String, @Field("password")password:String):Response<Auth>


}