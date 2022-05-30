package com.example.postsapp.domain.usecase

import com.example.postsapp.base.GeneralResponse
import com.example.postsapp.domain.model.PostDomainModel
import com.example.postsapp.domain.repository.PostsRepository

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(): GeneralResponse<List<PostDomainModel>> {
       return when (val response = postsRepository.getPosts()) {
            is GeneralResponse.OnSuccess -> GeneralResponse.OnSuccess(getPostsByOddId(response.response))
            is GeneralResponse.OnFailure -> GeneralResponse.OnFailure(response.message)
        }
    }

    private fun getPostsByOddId(posts: List<PostDomainModel>): List<PostDomainModel> {
        return posts.filter { it.id % 2 == 0 }
    }
}