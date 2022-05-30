package com.example.postsapp.data.mapper

import com.example.postsapp.data.dto.Post
import com.example.postsapp.domain.model.PostDomainModel

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsMapper {
    fun mapToPostsDomainModel(posts: List<Post>): List<PostDomainModel> {
        val postDomainModels = mutableListOf<PostDomainModel>()
        posts.forEach {
            postDomainModels.add(PostDomainModel(it.id, it.title, it.body))
        }
        return postDomainModels
    }
}