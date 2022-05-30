package com.example.postsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.databinding.PostRecyclerItemBinding
import com.example.postsapp.domain.model.PostDomainModel

/**
 * Created by Davit Soitashvili on 30.05.22
 **/

class PostsAdapter(private val posts: List<PostDomainModel>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_recycler_item, parent, false)
        return PostViewHolder(
            DataBindingUtil.bind(view)!!
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBindPost(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(private val binding : PostRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBindPost(postDomainModel: PostDomainModel) {
            binding.post = postDomainModel
        }
    }
}