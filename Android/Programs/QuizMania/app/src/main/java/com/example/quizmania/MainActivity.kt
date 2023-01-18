package com.example.quizmania

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay : Button = findViewById(R.id.btn_play)
        val btnTopics : Button = findViewById(R.id.btn_topics)

        btnPlay.setOnClickListener{
            val generator = Random()
            val number: Int = generator.nextInt(5) + 1
            var activity: Class<*>? = null
            activity = when (number) {
                1 -> JavaOneActivity::class.java
                2 -> JavaTwoActivity::class.java
                3 -> JavaThreeActivity::class.java
                4 -> JavaFourActivity::class.java
                else -> JavaFiveActivity::class.java
            }
            val intent = Intent(baseContext, activity)
            startActivity(intent)
        }

        btnTopics.setOnClickListener{
            val intent = Intent(applicationContext,TopicsActivity::class.java)
            startActivity(intent)
        }

        val btnTest : LinearLayout = findViewById(R.id.test)

        btnTest.setOnClickListener{
            val intent = Intent(applicationContext,FinalActivity::class.java)
            startActivity(intent)
        }
    }
}