package com.example.quizscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val back : TextView = findViewById(R.id.back)
        val btnSubmit : Button = findViewById(R.id.btn_submit)

        back.setOnClickListener{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

        btnSubmit.setOnClickListener{
            val intent = Intent(applicationContext,LastActivity::class.java)
            startActivity(intent)
        }
    }
}