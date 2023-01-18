package com.example.quizmania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.*

class TopicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)

        val btnJava : RelativeLayout = findViewById(R.id.sec_java)
        val btnGn : RelativeLayout = findViewById(R.id.sec_gn)
        val btnWeb : RelativeLayout = findViewById(R.id.sec_web)
        val btnBack : TextView = findViewById(R.id.back)

        btnBack.setOnClickListener{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

        btnJava.setOnClickListener{
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
    }
}