package com.example.quizmania

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val btnClose : TextView = findViewById(R.id.close)
        btnClose.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Do you want to exit ?")
            builder.setTitle("Alert!!")
            builder.setCancelable(false)
            builder.setPositiveButton("Yes"){
                    d, which -> finish()
            }
            builder.setNegativeButton("No"){
                    d, which -> d.cancel()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}