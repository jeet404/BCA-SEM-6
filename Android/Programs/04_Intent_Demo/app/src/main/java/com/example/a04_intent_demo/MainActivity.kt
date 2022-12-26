package com.example.a04_intent_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.btn_move)
        btn.setOnClickListener {
            val myIntent : Intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(myIntent)
        }
    }
}