package com.example.postsapp.data.datasource

import com.example.postsapp.base.GeneralResponse
import com.example.postsapp.data.dto.Post

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

interface PostsDataSource {
    suspend fun getPosts() : GeneralResponse<List<Post>>
}