package com.sk27.db_crud

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :  SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){

    companion object{
        private val DB_NAME = "dbStudent"
        private val DB_VERSION = 1
        private val TABLE_NAME = "sudentTable"
        private val ID = "id"
        private val STUDENT_NAME = "student_name"
        private val STUDENT_CLASS = "student_class"
        private val STUDENT_ADDRESS = "student_address"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $STUDENT_NAME TEXT, $STUDENT_CLASS TEXT, $STUDENT_ADDRESS TEXT);"
        p0?.execSQL(CREATE_TABLE)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)
    }

    //fetch
    @SuppressLint("Range")
    fun getAllStudent():List<StudentListModel> {
        val studentList = ArrayList<StudentListModel>()
        val db = writableDatabase
        val selectQ = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQ, null)
        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    val student = StudentListModel()
                    student.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    student.sName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME))
                    student.sClass = cursor.getString(cursor.getColumnIndex(STUDENT_CLASS))
                    student.sAddress = cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS))
                    studentList.add(student)
                }while(cursor.moveToNext())
            }
        }
        cursor.close()
        return studentList
    }

    //Insert student
    fun addStudent(student : StudentListModel): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(STUDENT_NAME, student.sName)
        values.put(STUDENT_CLASS, student.sClass)
        values.put(STUDENT_ADDRESS, student.sAddress)
        val success = db.insert(TABLE_NAME,null,values)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

    //select id data
    @SuppressLint("Range")
    fun getStudent(id: Int):StudentListModel {
        val student = StudentListModel()
        val db = writableDatabase
        val sQ = "SELECT * FROM $TABLE_NAME WHERE id = $id"
        val cursor = db.rawQuery(sQ,null)
        cursor.moveToFirst()
        student.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                student.sName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME))
                student.sClass = cursor.getString(cursor.getColumnIndex(STUDENT_CLASS))
                student.sAddress = cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS))
                cursor.close()
            return student

    }

    //delete student
    fun deleteStudent(id: Int): Boolean{
        val db = this.writableDatabase
        val success = db.delete(TABLE_NAME,ID +"=?",arrayOf(id.toString())).toLong()
        db.close()
        return Integer.parseInt("$success") != 1

    }

    //update
    fun updateStudent(student: StudentListModel): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(STUDENT_NAME, student.sName)
        values.put(STUDENT_CLASS, student.sClass)
        values.put(STUDENT_ADDRESS, student.sAddress)
        val success = db.update(TABLE_NAME,values, ID+ "=?",arrayOf(student.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$success") != -1
    }
}