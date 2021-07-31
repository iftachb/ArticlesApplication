package com.example.articlesapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunicationManager() {
    private val request = CommunicatioBuilder.build(ArticlesEndpoints::class.java)

    fun getArticles() {
        val call = request.getArticles()
        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    MainManager.getInstance().showArticles(response)
                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                MainManager.getInstance().failCommunication(t)
            }
        })

    }
}