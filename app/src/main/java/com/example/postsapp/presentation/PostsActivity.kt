package com.example.postsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.domain.model.PostDomainModel
import com.example.postsapp.presentation.adapter.PostsAdapter
import com.example.postsapp.presentation.vm.PostsVm
import org.koin.android.ext.android.inject

class PostsActivity : AppCompatActivity() {

    private val postsVm: PostsVm by inject()

    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        postsVm.makePostsApiCall()

        postsVm.posts.observe(this) {
            initPostsAdapter(it)
        }

        postsVm.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initPostsAdapter(posts: List<PostDomainModel>) {
        postsAdapter = PostsAdapter(posts)
        val postRecyclerView = findViewById<RecyclerView>(R.id.postsRecyclerView)
        postRecyclerView.layoutManager = LinearLayoutManager(this)
        postRecyclerView.adapter = postsAdapter
    }
}