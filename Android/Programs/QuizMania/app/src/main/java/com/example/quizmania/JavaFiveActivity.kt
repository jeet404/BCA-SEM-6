package com.example.quizmania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class JavaFiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_five)


        val btnBack : TextView = findViewById(R.id.back)

        btnBack.setOnClickListener{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}