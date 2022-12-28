package com.example.a05_loginpagetask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uname:EditText = findViewById(R.id.txt_uname)
        val upass:EditText = findViewById(R.id.txt_pass)
        val btnL:Button = findViewById(R.id.btn_login)

        btnL.setOnClickListener {
            if (uname.text.toString().equals("Jeet404")&&upass.text.toString().equals("jeet@404")){
                Toast.makeText(applicationContext,"Logged In Successfully",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(applicationContext,"Wrong Data Inserted!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}