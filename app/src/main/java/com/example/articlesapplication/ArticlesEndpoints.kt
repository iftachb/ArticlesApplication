package com.example.articlesapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesEndpoints {
    companion object {
        const val BASE_URL = "https://cdn.theculturetrip.com/"
    }

    @GET("home-assignment/response.json")
    fun getArticles(): Call<Data>

}