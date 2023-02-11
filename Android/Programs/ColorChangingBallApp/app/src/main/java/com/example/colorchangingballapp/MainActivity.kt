package com.example.colorchangingballapp

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import android.content.Context
import android.util.AttributeSet
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ballX = 0f
        var ballY = 0f
        var ballSpeedX = 10f
        var ballSpeedY = 5f
        val ballRadius = 50f
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = ResourcesCompat.getColor(resources, R.color.purple_500, null)
        }

        val ballBitmap: Bitmap by lazy {
            val bitmap = (ResourcesCompat.getDrawable(resources, R.drawable.ball, null) as BitmapDrawable).bitmap
            Bitmap.createScaledBitmap(bitmap, ballRadius.toInt() * 2, ballRadius.toInt() * 2, true)
        }
    }
}