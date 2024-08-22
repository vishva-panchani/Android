package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
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

        var listview:ListView=findViewById(R.id.listView)
        var city= arrayOf("Rajkot","Baroda","Surat")
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        listview.adapter=adapter

        listview.setOnItemClickListener { adapterView, view, position, id ->
            var value=listview.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}