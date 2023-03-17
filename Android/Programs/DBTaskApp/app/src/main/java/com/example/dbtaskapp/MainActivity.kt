package com.example.dbtaskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recycler_student : RecyclerView
    lateinit var btn_add : Button
    var studentListAdapter: StudentListAdapter?= null
    var dbHendler : DatabaseHelper?= null
    var studentlist : List<StudentListModel> = ArrayList<StudentListModel>()
    var LinearLayoutManager:LinearLayoutManager ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_student = findViewById(R.id.student_list)
        btn_add = findViewById(R.id.btn_add_student)

        dbHendler = DatabaseHelper(this)
        fetchList()

        btn_add.setOnClickListener {
            val i = Intent(applicationContext, add_student::class.java)
            startActivity(i)
        }

    }
    private fun fetchList(){
        studentlist = dbHendler!!.getAllStudent()
        studentListAdapter = StudentListAdapter(studentlist,applicationContext)
        LinearLayoutManager = LinearLayoutManager(applicationContext)
        recycler_student.layoutManager = LinearLayoutManager
        recycler_student.adapter = studentListAdapter
        studentListAdapter?.notifyDataSetChanged()

    }
}