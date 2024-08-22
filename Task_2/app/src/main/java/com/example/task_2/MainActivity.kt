package com.example.task_2

import android.content.Intent
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

        var listview: ListView =findViewById(R.id.listView)
        var city= arrayOf("Rajkot","Surat","Baroda","Ahemdabad","Jaipur")
        var adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        listview.adapter=adapter

        listview.setOnItemClickListener { adapterView, view, position, id ->
            var value=listview.getItemAtPosition(position).toString()
            if (value=="Rajkot") {
                var i = Intent(this, RajkotActivity::class.java)
                startActivity(i)
            }
            else if(value=="Surat"){
                var s = Intent(this, SuratActivity::class.java)
                startActivity(s)
            }
            else if(value=="Baroda"){
                var b = Intent(this, BarodaActivity::class.java)
                startActivity(b)
            }
            else if(value=="Ahemdabad"){
                var a = Intent(this, AhemdabadActivity::class.java)
                startActivity(a)
            }
            else if(value=="Jaipur"){
                var j = Intent(this, JaipurActivity::class.java)
                startActivity(j)
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}