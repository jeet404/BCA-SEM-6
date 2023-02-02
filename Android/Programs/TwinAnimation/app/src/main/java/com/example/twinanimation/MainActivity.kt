package com.example.twinanimation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textA : TextView = findViewById(R.id.txtAnim)
        val fadeIn : Button = findViewById(R.id.btn_fadein)
        val fadeout : Button = findViewById(R.id.btn_fadeout)
        val zoomIn : Button = findViewById(R.id.btn_zoomin)
        val zoomOut : Button = findViewById(R.id.btn_zoomout)
        val slideUp : Button = findViewById(R.id.btn_slideup)
        val slideDown : Button = findViewById(R.id.btn_slidedown)
        val rotateB : Button = findViewById(R.id.btn_rotate)
        val bounceB : Button = findViewById(R.id.btn_bounce)

        fadeIn.setOnClickListener{
            textA.visibility = View.VISIBLE
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            textA.startAnimation(animationFadeIn)
        }

        fadeout.setOnClickListener {
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            textA.startAnimation(animationFadeOut)
            Handler().postDelayed({
                textA.visibility = View.GONE
            },1000)
        }

        zoomIn.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            textA.startAnimation(animationZoomIn)
        }

        zoomOut.setOnClickListener {
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            textA.startAnimation(animationZoomOut)
        }

        slideDown.setOnClickListener {
            val animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            textA.startAnimation(animationSlideDown)
        }
        slideUp.setOnClickListener {
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            textA.startAnimation(animationSlideUp)
        }
        bounceB.setOnClickListener {
            val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            textA.startAnimation(animationBounce)
        }
        rotateB.setOnClickListener {
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            textA.startAnimation(animationRotate)
        }
    }
}