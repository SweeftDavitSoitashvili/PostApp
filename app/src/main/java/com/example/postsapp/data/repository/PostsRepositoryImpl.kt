package com.example.postsapp.data.repository

import com.example.postsapp.base.GeneralResponse
import com.example.postsapp.data.datasource.PostsDataSource
import com.example.postsapp.data.mapper.PostsMapper
import com.example.postsapp.domain.model.PostDomainModel
import com.example.postsapp.domain.repository.PostsRepository

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsRepositoryImpl(
    private val postsDataSource: PostsDataSource,
    private val postsMapper: PostsMapper
) : PostsRepository {
    override suspend fun getPosts(): GeneralResponse<List<PostDomainModel>> {
        return when (val res = postsDataSource.getPosts()) {
            is GeneralResponse.OnSuccess -> GeneralResponse.OnSuccess(
                postsMapper.mapToPostsDomainModel(
                    res.response
                )
            )
            is GeneralResponse.OnFailure -> GeneralResponse.OnFailure(res.message)
        }
    }
}