package com.example.mydatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context): SQLiteOpenHelper(context,"STUDENT_DB",null,1)
{
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE STUDENT(STD INTEGER PRIMARY KEY AUTOINCREMENT,SNAME TEXT,SEM NUMBER )")
        p0?.execSQL("INSERT INTO STUDENT(SNAME,SEM) VALUES('VISHVA',3)")
        p0?.execSQL("INSERT INTO STUDENT(SNAME,SEM) VALUES('PARI',5)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}