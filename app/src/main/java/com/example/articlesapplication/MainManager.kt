package com.example.articlesapplication

import retrofit2.Response

class MainManager {
    companion object {
        private val mainManager : MainManager = MainManager()
        public fun getInstance(): MainManager = mainManager
    }
    private val communicationManager: CommunicationManager =  CommunicationManager()
    private var events: MutableList<Event> = mutableListOf()

    fun setEvent(event :Event) {
        events.add(event)
    }

    fun removeEvent(event :Event) {
        events.remove(event)
    }
    fun getArticles() {
        communicationManager.getArticles()
    }

    fun showArticles(response: Response<Data>) {
        events.map{ event -> event.showArticles(response) }
    }

    fun failCommunication(e: Throwable) {
        events.map{ event -> event.failCommunication(e) }
    }
}