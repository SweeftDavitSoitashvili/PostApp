package com.example.postsapp.base

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

sealed class GeneralResponse<T> {
    class OnSuccess<T>(val response : T) : GeneralResponse<T>()
    class OnFailure<T>(val message : String) : GeneralResponse<T>()
}