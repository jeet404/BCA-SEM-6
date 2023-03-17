package com.example.dbtaskapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentListAdapter(studentList:List<StudentListModel>, internal var context: Context) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    internal var studentList : List<StudentListModel> = ArrayList()

    init {
        this.studentList = studentList
    }
    inner class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var sname : TextView = view.findViewById(R.id.txt_sname)
        var sclass : TextView = view.findViewById(R.id.txt_sclass)
        var saddress : TextView = view.findViewById(R.id.txt_saddress)
        var btnEdit : Button = view.findViewById(R.id.btn_edit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_student_list,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.sname.text = student.sName
        holder.sclass.text = student.sClass
        holder.saddress.text = student.sAddress

        holder.btnEdit.setOnClickListener {
            val i:Intent = Intent(context, add_student::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("Mode","E")
            i.putExtra("Id",student.id)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}