package com.example.bounceballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img_ball:ImageView = findViewById(R.id.ball)
        val bounce:Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.bounce)
        img_ball.startAnimation(bounce)

    }
}