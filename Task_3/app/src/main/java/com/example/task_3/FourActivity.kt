package com.example.task_3

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_four)



        var txtSName: EditText =findViewById(R.id.editSnm1)
        var txtName: EditText =findViewById(R.id.editNm1)
        var txtEmail: EditText =findViewById(R.id.editMail1)
        var txtPass:EditText=findViewById(R.id.editPass1)
        var txtDate: EditText =findViewById(R.id.editDob1)
        var txtGender: RadioGroup =findViewById(R.id.rbGen1)
        var txtCity: EditText =findViewById(R.id.aCtvCity1)
        var btn_edit:Button=findViewById(R.id.btnEdit)

        var sp1=application.getSharedPreferences("login", Context.MODE_PRIVATE)
        var editor=sp1.edit()

            txtSName.setText(sp1.getString("surname",""))
            txtName.setText(sp1.getString("name",""))
            txtEmail.setText(sp1.getString("email",""))
            txtPass.setText(sp1.getString("password",""))
            txtDate.setText(sp1.getString("date",""))
            txtCity.setText(sp1.getString("city",""))


        btn_edit.setOnClickListener {
            editor.putString("surname",txtSName.text.toString())
            editor.putString("name",txtName.text.toString())
            editor.putString("email",txtEmail.text.toString())
            editor.putString("password",txtPass.text.toString())
            editor.putString("date",txtDate.text.toString())
            editor.putString("city",txtCity.text.toString())

            editor.commit()



        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}