package com.example.logintaskwithsp

import android.R
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {
    var prf: SharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE)
    var intent: Intent = Intent(this@DetailsActivity, MainActivity::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        val result = findViewById<View>(R.id.resultView) as TextView
        val btnLogOut: Button = findViewById<View>(R.id.btnLogOut) as Button
        result.text = "Hello, " + prf.getString("username", null)
        btnLogOut.setOnClickListener(object : DialogInterface.OnClickListener() {
            fun onClick(v: View?) {
                val editor = prf.edit()
                editor.clear()
                editor.commit()
                startActivity(intent)
            }
        })
    }
}