package com.example.a04_intent_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btn : Button = findViewById(R.id.btn_back)
        btn.setOnClickListener {
            val myIntent : Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(myIntent)
        }
    }
}