package com.example.postsapp.domain.repository

import com.example.postsapp.base.GeneralResponse
import com.example.postsapp.domain.model.PostDomainModel

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

interface PostsRepository {
    suspend fun getPosts() : GeneralResponse<List<PostDomainModel>>
}