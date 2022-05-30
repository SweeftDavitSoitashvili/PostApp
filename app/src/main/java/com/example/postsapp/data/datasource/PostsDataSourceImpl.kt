package com.example.postsapp.data.datasource

import com.example.postsapp.base.GeneralResponse
import com.example.postsapp.data.apiservice.PostsApiService
import com.example.postsapp.data.dto.Post
import java.lang.Exception

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsDataSourceImpl(private val postsApiService: PostsApiService) : PostsDataSource {
    override suspend fun getPosts(): GeneralResponse<List<Post>> {
        return try {
            val response = postsApiService.getPosts()
            if (response.isSuccessful) {
                GeneralResponse.OnSuccess(response = response.body()!!)
            } else {
                GeneralResponse.OnFailure(message = response.message())
            }
        } catch (exception : Exception) {
            GeneralResponse.OnFailure(message = exception.message!!)
        }
    }

}