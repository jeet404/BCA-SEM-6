package com.example.gungumstyleanimation

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var pause: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animImg: ImageView = findViewById(R.id.animCat)
        val btnPlay: Button = findViewById(R.id.btn_play)
        val btnStop: Button = findViewById(R.id.btn_stop)
        val btnPause: Button = findViewById(R.id.btn_pause)

        btnPlay.setOnClickListener {
            if (pause) {
                mediaPlayer.start()
                pause = false
                val bgImage = animImg.background as AnimationDrawable
                bgImage.start()
            } else {
                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.gangnumring)
                mediaPlayer.start()
                val bgImage = animImg.background as AnimationDrawable
                bgImage.start()
            }
            btnPlay.isEnabled = false
            btnPause.isEnabled = true
            btnStop.isEnabled = true
            mediaPlayer.setOnCompletionListener {
                btnPlay.isEnabled = true
                btnPause.isEnabled = false
                btnStop.isEnabled = false
                val bgImage = animImg.background as AnimationDrawable
                bgImage.stop()
            }
        }

        btnPause.setOnClickListener{
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                pause=true
                btnPlay.isEnabled=true
                btnPause.isEnabled=false
                btnStop.isEnabled=true
                val bgImage = animImg.background as AnimationDrawable
                bgImage.stop()
            }
        }

        btnStop.setOnClickListener{
            if(mediaPlayer.isPlaying || pause){
                pause=false
                mediaPlayer.stop()
                mediaPlayer.reset()
                btnPlay.isEnabled=true
                btnPause.isEnabled=false
                btnStop.isEnabled=false
                val bgImage = animImg.background as AnimationDrawable
                bgImage.stop()
                }
            }
    }
}