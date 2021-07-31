package com.example.articlesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var buttonArtist: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonArtist = findViewById<Button>(R.id.buttonArtists)
        buttonArtist.setOnClickListener {
            startActivity(Intent(this, ArticlesActivity::class.java))
        }

    }
}