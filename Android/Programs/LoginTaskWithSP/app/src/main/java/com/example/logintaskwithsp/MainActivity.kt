package com.example.logintaskwithsp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var uname: EditText = findViewById(R.id.txtUname)
        var pwd: EditText = findViewById(R.id.txtPass)
        var loginBtn: Button = findViewById(R.id.btnLogin)
        var pref: SharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
        var intent: Intent = Intent(this@MainActivity, DetailsActivity::class.java)
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
        loginBtn.setOnClickListener{
            fun onClick(v: View?) {
                val username = uname.text.toString()
                val password = pwd.text.toString()
                if (username == "jeet404" && password == "jeet@404") {
                    val editor = pref.edit()
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.commit()
                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Credentials are not valid",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}