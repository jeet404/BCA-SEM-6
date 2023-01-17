package com.example.quizscreen

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movebtn0 : LinearLayout = findViewById(R.id.ant_sec)
        val movebtn1 : LinearLayout = findViewById(R.id.gn_sec)
        val movebtn2 : LinearLayout = findViewById(R.id.snt_sec)

        movebtn0.setOnClickListener{
            val intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(intent)
        }
        movebtn1.setOnClickListener{
            val intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(intent)
        }
        movebtn2.setOnClickListener{
            val intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}