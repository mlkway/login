package com.raywenderlich.usecases

import retrofit2.HttpException
import java.lang.Exception

class ResponseHandler {

    fun<T> handleException(e: Exception, data:T? = null):Resource<T>{
        return when(e){
            is HttpException -> Resource.error(data,"HttpException")
            else -> Resource.error(data, "unknown error!")
        }
    }

    fun<T> handleSuccess(data:T?):Resource<T>{
        return Resource.success(data)
    }

    fun <T> handleDefaultException(data: T? = null):Resource<T>{
        return Resource.error(data,"unknown error")
    }

    fun <T> handleLoading(data: T? = null):Resource<T>{
        return Resource.loading(data)
    }


}