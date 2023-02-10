package com.example.charanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var characterImage: ImageView
    lateinit var danceButton: Button
    lateinit var walkButton: Button
    lateinit var runButton: Button
    lateinit var jumpButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterImage = findViewById(R.id.img_char)
        danceButton = findViewById(R.id.dance_button)
        walkButton = findViewById(R.id.walk_button)
        runButton = findViewById(R.id.run_button)
        jumpButton = findViewById(R.id.goSchool_button)
        danceButton.setOnClickListener { playAnimation(R.drawable.dance) }
        walkButton.setOnClickListener { playAnimation(R.drawable.walk) }
        runButton.setOnClickListener { playAnimation(R.drawable.run) }
        jumpButton.setOnClickListener { playAnimation(R.drawable.gotoschool) }
    }
    private fun playAnimation(animationId: Int) {
        characterImage.setBackgroundResource(animationId)
        val animationDrawable = characterImage.background as AnimationDrawable
        animationDrawable.start()
    }
}