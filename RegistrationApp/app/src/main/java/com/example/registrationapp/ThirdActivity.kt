package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)


        var txtName: TextView =findViewById(R.id.textView)
        var txtEmail:TextView=findViewById(R.id.textView9)
        var txtHobby:TextView=findViewById(R.id.textView10)
        var txtCity:TextView=findViewById(R.id.textView11)
        var txtGender:TextView=findViewById(R.id.textView12)
        var txtDate:TextView=findViewById(R.id.textView13)


        var intent: Intent = intent

        var dName=intent.getStringExtra("name")
        txtName.setText("Name:"+dName)

        var dEmail=intent.getStringExtra("email")
        txtEmail.setText("Email:"+dEmail)

        var dHobby=intent.getStringExtra("hobbies")
        txtHobby.setText("Hobbies:"+dHobby)

        var dCity=intent.getStringExtra("city")
        txtCity.setText("City:"+dCity)

        var dGender=intent.getStringExtra("gender")
        txtGender.setText("Gender:"+dGender)

        var ddate=intent.getStringExtra("date")
        txtDate.setText("BirthDate:"+ddate)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}