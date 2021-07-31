package com.example.articlesapplication

import retrofit2.Response

interface Event {
    fun showArticles(response: Response<Data>)
    fun failCommunication(e :Throwable)
}