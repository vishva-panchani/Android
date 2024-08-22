package com.example.task_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btnurl:Button=findViewById(R.id.button)

        btnurl.setOnClickListener {
            var i = Intent(this,UrlActivity::class.java)
            startActivity(i)
        }

        var btnfrm:Button=findViewById(R.id.button2)

        btnfrm.setOnClickListener {
            var i = Intent(this,FormActivity::class.java)
            startActivity(i)
        }

        var btnrtn:Button=findViewById(R.id.button3)

        btnrtn.setOnClickListener {
            var i = Intent(this,SeekBarActivity::class.java)
            startActivity(i)
        }

        var btnimg:Button=findViewById(R.id.button4)

        btnimg.setOnClickListener {
            var i = Intent(this,ImageActivity::class.java)
            startActivity(i)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}