package com.sk27.db_crud

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class add_student : AppCompatActivity() {
    lateinit var btn_save : Button
    lateinit var btn_del : Button
    lateinit var et_sname : EditText
    lateinit var et_sclass : EditText
    lateinit var et_saddress : EditText
    var dbHandler : DatabaseHelper ? = null
    var isEditMode : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        btn_save = findViewById(R.id.btn_addstudent)
        btn_del = findViewById(R.id.btn_delstudent)
        et_sname = findViewById(R.id.edt_sname)
        et_sclass = findViewById(R.id.edt_sclass)
        et_saddress = findViewById(R.id.edt_saddress)
        dbHandler = DatabaseHelper(this)

        if(intent != null && intent.getStringExtra("Mode") == "E"){
            //update
            isEditMode = true
            btn_save.text = "Update"
            btn_del.visibility = View.VISIBLE
            val student : StudentListModel = dbHandler!!.getStudent(intent.getIntExtra("Id",0))
            et_sname.setText(student.sName)
            et_sclass.setText(student.sClass)
            et_saddress.setText(student.sAddress)
        }else{
            //insert
            isEditMode = false
            btn_save.text = "Save"
            btn_del.visibility = View.GONE
        }
        btn_save.setOnClickListener {
            var success : Boolean = false
            val students : StudentListModel = StudentListModel()

            if(isEditMode){
                //update
                students.id = intent.getIntExtra("Id",0)
                students.sName = et_sname.text.toString()
                students.sClass = et_sclass.text.toString()
                students.sAddress = et_saddress.text.toString()

                success = dbHandler?.updateStudent(students) as Boolean
                var i = Intent(applicationContext,MainActivity::class.java)
                startActivity(i)

            }else{
                //insert
                students.sName = et_sname.text.toString()
                students.sClass = et_sclass.text.toString()
                students.sAddress = et_saddress.text.toString()

                success = dbHandler?.addStudent(students) as Boolean
                if(success){
                    val i = Intent(applicationContext,MainActivity::class.java)
                    startActivity(i)
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Not Inserted",Toast.LENGTH_LONG).show()
                }
            }
        }
        btn_del.setOnClickListener {
            val dialog = AlertDialog.Builder(this).setTitle("Info").setMessage("Click yes if you want to delete student")
                .setPositiveButton("Yes",{ dialog, i->
                    val success = dbHandler?.deleteStudent(intent.getIntExtra("Id",0)) as Boolean
                    if(success)
                        finish()
                    dialog.dismiss()
                    var i = Intent(applicationContext,MainActivity::class.java)
                    startActivity(i)
                })
                .setNegativeButton("No",{ dialog, i ->
                    dialog.dismiss()
                })
            dialog.show()
        }

    }
}