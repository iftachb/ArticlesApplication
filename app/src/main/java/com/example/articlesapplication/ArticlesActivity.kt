package com.example.articlesapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.AuthorsAdapter
import kotlinx.android.synthetic.main.aiticles.*
import retrofit2.Response

class ArticlesActivity : AppCompatActivity(), Event {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aiticles)
        MainManager.getInstance().setEvent(this)

        MainManager.getInstance().getArticles()
    }

    override fun showArticles(response: Response<Data>) {
        if (response.isSuccessful) {
            progress_bar.visibility = View.GONE
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@ArticlesActivity)
                adapter = AuthorsAdapter(response.body()!!.results!!)
            }
        }
    }

    override fun failCommunication(e: Throwable) {
        Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        MainManager.getInstance().removeEvent(this)
    }
}