package com.example.typesofintent

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        var txtSurname:TextView=findViewById(R.id.textView2)
        var txtName:TextView=findViewById(R.id.textView3)

        var intent:Intent=intent
        var sName=intent.getStringExtra("surname")
        var Name=intent.getStringExtra("name")

        txtSurname.setText("Surname:"+sName)
        txtName.setText("Name:"+Name)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}