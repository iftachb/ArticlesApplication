package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.articlesapplication.R
import com.example.articlesapplication.Results

class AuthorsAdapter(
        val results: List<Results>
    ): RecyclerView.Adapter<AuthorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return AuthorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        return holder.bind(results[position])
    }
}

class AuthorViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    private val photo:ImageView = itemView.findViewById(R.id.article_photo)
    private val title:TextView = itemView.findViewById(R.id.article_title)
    private val likeCount:TextView = itemView.findViewById(R.id.like_count)
    private val save:ImageView = itemView.findViewById(R.id.save)
    private val like:ImageView = itemView.findViewById(R.id.like)

    private val authorName:TextView = itemView.findViewById(R.id.author_name)
    private val authorTime:TextView = itemView.findViewById(R.id.article_category)
    private val authorAvatar:ImageView = itemView.findViewById(R.id.author_avatar)

    fun bind(result: Results) {
        Glide.with(itemView.context).load(result.imageUrl).into(photo)
        title.text = result.title
        if (!result.isSaved) {
            save.visibility = View.INVISIBLE
        }
        if (!result.isLiked) {
            like.visibility = View.INVISIBLE
            likeCount.visibility = View.INVISIBLE
        }
        else {
            likeCount.text = result.likesCount.toString()
        }
        authorTime.text = result.category
        authorName.text = result.author?.authorName
        Glide.with(itemView.context).load(result.author?.authorAvatar?.imageUrl).into(authorAvatar)
    }

}
