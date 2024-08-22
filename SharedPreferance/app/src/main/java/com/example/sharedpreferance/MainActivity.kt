package com.example.sharedpreferance

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var ed_nm:EditText=findViewById(R.id.editName)
        var ed_pass:EditText=findViewById(R.id.editPass)
        var btn_save:Button=findViewById(R.id.saveBtn)
        var btn_view:Button=findViewById(R.id.viewBtn)

        var sp=application.getSharedPreferences("login",Context.MODE_PRIVATE)
        var editor=sp.edit()

        btn_save.setOnClickListener {
            editor.putString("unm",ed_nm.text.toString())
            editor.putString("pass",ed_pass.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Data Saved",Toast.LENGTH_LONG).show()
            ed_nm.setText("")
            ed_pass.setText("")
        }

        btn_view.setOnClickListener {
            ed_nm.setText(sp.getString("unm",""))
            ed_pass.setText(sp.getString("pass",""))
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}