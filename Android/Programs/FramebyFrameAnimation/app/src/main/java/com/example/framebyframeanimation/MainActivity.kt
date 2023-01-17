package com.example.framebyframeanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val btnStop : Button = findViewById(R.id.btn_stop)
        val animImg : ImageView = findViewById(R.id.anim_img)

        btnStart.setOnClickListener{
            val bgImage = animImg.background as AnimationDrawable
            bgImage.start()
        }
        btnStop.setOnClickListener{
            val bgImage = animImg.background as AnimationDrawable
            bgImage.stop()
        }
    }
}