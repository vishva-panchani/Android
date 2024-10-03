package com.example.mydatabasecrud

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var ed_sname: EditText
    lateinit var ed_sem: EditText
    lateinit var btn_insert: Button
    lateinit var btn_clear: Button
    lateinit var btn_delete: Button
    lateinit var btn_update: Button
    lateinit var btn_showall:Button
    lateinit var btn_next:Button
    lateinit var btn_pre:Button
    lateinit var btn_first:Button
    lateinit var btn_last:Button
    lateinit var listView: ListView
    lateinit var search:SearchView
    lateinit var rs: Cursor

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ed_sname = findViewById(R.id.ed_sname)
        ed_sem = findViewById(R.id.ed_sem)
        btn_insert = findViewById(R.id.btn_insert)
        btn_update = findViewById(R.id.btn_update)
        btn_delete = findViewById(R.id.btn_delete)
        btn_clear = findViewById(R.id.btn_clear)
        btn_next=findViewById(R.id.btn_next)
        btn_last=findViewById(R.id.btn_last)
        btn_first=findViewById(R.id.btn_first)
        btn_pre=findViewById(R.id.btn_prev)
        btn_showall = findViewById(R.id.btn_show)
        listView=findViewById(R.id.listview1)
        search=findViewById(R.id.searchbtn)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
       //Toast.makeText( applicationContext, "db and table", Toast.LENGTH_SHORT).show()

        rs = db.rawQuery("SELECT SID _id, SNAME, SEM FROM STUDENT", null)
        if (rs.moveToFirst()) {
            ed_sname.setText(rs.getString(1))
            ed_sem.setText(rs.getString(2))
        }

        //insert
        btn_insert.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME", ed_sname.text.toString())
            cv.put("SEM", ed_sem.text.toString())
            db.insert("STUDENT", null, cv)
            rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT", null)
            showMessage("Inserted Successfully!!!")
            clear()
        }

        //Update
        btn_update.setOnClickListener {

            var cv = ContentValues()
            cv.put("SNAME", ed_sname.text.toString())
            cv.put("SEM", ed_sem.text.toString())
            db.update("STUDENT", cv, "SID = ?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT", null)
            showMessage("Update Succcessfully!!")
            clear()
        }

        //Delete
        btn_delete.setOnClickListener {
            db.delete("STUDENT","SID=?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT", null)
            showMessage("Delete Succcessfully!!")
            clear()
        }

        //clear
        btn_clear.setOnClickListener {
            clear()
        }

        //prev
        btn_pre.setOnClickListener {
            if (rs.moveToPrevious())
            {
                ed_sname.setText((rs.getString(1)))
                ed_sem.setText((rs.getString(2)))
            }else if (rs.moveToLast())
            {
                ed_sname.setText((rs.getString(1)))
                ed_sem.setText((rs.getString(2)))
            }else
            {
                Toast.makeText(applicationContext,"Data not Found",Toast.LENGTH_LONG).show()
            }
        }

        //next
        btn_next.setOnClickListener {
            if (rs.moveToNext())
            {
                ed_sname.setText((rs.getString(1)))
                ed_sem.setText((rs.getString(2)))
            }else if (rs.moveToFirst())
            {
                ed_sname.setText((rs.getString(1)))
                ed_sem.setText((rs.getString(2)))
            }else
            {
                Toast.makeText(applicationContext,"Data not Found",Toast.LENGTH_LONG).show()
            }
        }

        //first
        btn_first.setOnClickListener {
            if (rs.moveToFirst())
            {
                ed_sname.setText((rs.getString(1)))
                ed_sem.setText((rs.getString(2)))
            }else
            {
                Toast.makeText(applicationContext,"Data not Found",Toast.LENGTH_LONG).show()
            }
        }

        //last
        btn_last.setOnClickListener {
            if (rs.moveToLast())
            {
                ed_sname.setText((rs.getString(1)))
                ed_sem.setText((rs.getString(2)))
            }else
            {
                Toast.makeText(applicationContext,"Data not Found",Toast.LENGTH_LONG).show()
            }
        }


        //show all records
        btn_showall.setOnClickListener {
            var adapter= SimpleCursorAdapter(applicationContext,R.layout.my_layout,rs,
                arrayOf("SNAME","SEM"),
                intArrayOf(R.id.textview1,R.id.textview2 ))
            listView.adapter=adapter


        //search:
            search.setOnQueryTextListener(object :SearchView.OnQueryTextListener
            {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                  return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    rs=db.rawQuery("SELECT SID _id ,SNAME,SEM FROM STUDENT WHERE SNAME LIKE '%${p0}%'",null)
                    adapter.changeCursor(rs)
                  return false
                }

            })

        }
    }


    //clear function
    private fun clear() {
        ed_sname.setText("")
        ed_sem.setText("")
        ed_sname.requestFocus()
    }

    //message function
    private fun showMessage(s:String) {
        AlertDialog.Builder(this)
            .setTitle("Success")
            .setMessage(s)
            .setPositiveButton("OK", DialogInterface.OnClickListener{ DialogInterface, i->
                if(rs.moveToFirst())
                {
                    ed_sname.setText(rs.getString(1))
                    ed_sem.setText(rs.getString(2))
                }else
                {
                    Toast.makeText(applicationContext,"Data Not Found", Toast.LENGTH_LONG).show()
                }
            }).show()

    }
}



