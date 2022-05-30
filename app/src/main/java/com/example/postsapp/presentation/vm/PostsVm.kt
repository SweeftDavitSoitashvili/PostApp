package com.example.postsapp.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.base.GeneralResponse
import com.example.postsapp.domain.model.PostDomainModel
import com.example.postsapp.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsVm(private val postsUseCase: PostsUseCase) : ViewModel() {
    private val _posts = MutableLiveData<List<PostDomainModel>>()
    val posts: LiveData<List<PostDomainModel>> = _posts

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun makePostsApiCall() {
        viewModelScope.launch {
            when (val response = postsUseCase.invoke()) {
                is GeneralResponse.OnSuccess -> _posts.value = response.response
                is GeneralResponse.OnFailure -> _errorMessage.value = response.message
            }
        }
    }
}