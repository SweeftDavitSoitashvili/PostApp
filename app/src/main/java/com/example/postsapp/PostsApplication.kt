package com.example.postsapp

import android.app.Application
import com.example.postsapp.data.apiservice.PostsApiService
import com.example.postsapp.data.datasource.PostsDataSource
import com.example.postsapp.data.datasource.PostsDataSourceImpl
import com.example.postsapp.data.mapper.PostsMapper
import com.example.postsapp.data.network.RetrofitClient
import com.example.postsapp.data.repository.PostsRepositoryImpl
import com.example.postsapp.domain.repository.PostsRepository
import com.example.postsapp.domain.usecase.PostsUseCase
import com.example.postsapp.presentation.vm.PostsVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoinModule()
    }

    private fun initKoinModule() {
        val koinApplication = startKoin { }
        koinApplication.modules(modules = module {
            single<Retrofit> { RetrofitClient().getRetrofit() }
            single<PostsApiService> { get<Retrofit>().create(PostsApiService::class.java) }
            factory<PostsDataSource> { PostsDataSourceImpl(get()) }
            single { PostsMapper() }
            single<PostsRepository> { PostsRepositoryImpl(get(), get()) }
            factory { PostsUseCase(get()) }
            viewModel { PostsVm(get()) }
        })
    }
}