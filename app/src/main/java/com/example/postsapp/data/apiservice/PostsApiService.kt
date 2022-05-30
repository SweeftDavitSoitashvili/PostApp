package com.example.postsapp.data.apiservice

import com.example.postsapp.data.dto.Post
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts() : Response<List<Post>>
}