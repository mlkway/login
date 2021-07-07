package com.raywenderlich.repo

import com.raywenderlich.model.Auth
import com.raywenderlich.network.ApiService
import com.raywenderlich.network.UserService
import com.raywenderlich.usecases.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService):UserRepository {


    override suspend fun getUser(email: String, password: String): Resource<Auth> {

        return try {
            val response = apiService.apiService.userAuth(email,password)
            if (response.isSuccessful){
                Resource.success(response.body())
            }else{
                Resource.error(response.errorBody())
            }



        }catch (e: Exception){
            Resource.error(e.message.toString())
        }

    }


}