package com.example.task_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        var ed_nm: EditText =findViewById(R.id.editTextText)
        var ed_pass: EditText =findViewById(R.id.editTextText2)
        var btn_log: Button =findViewById(R.id.buttonLogin)
        var btn_reg: Button =findViewById(R.id.buttonReg)

        var sp=application.getSharedPreferences("login", Context.MODE_PRIVATE)
        var editor=sp.edit()

        btn_log.setOnClickListener {
            editor.putString("unm",ed_nm.text.toString())
            editor.putString("pass",ed_pass.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Login Successfully", Toast.LENGTH_LONG).show()
            ed_nm.setText("")
            ed_pass.setText("")
        }

        btn_reg.setOnClickListener {
                var i= Intent(this,ThirdActivity::class.java)
                startActivity(i)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}