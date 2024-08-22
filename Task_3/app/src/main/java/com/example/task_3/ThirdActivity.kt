package com.example.task_3

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        //Submit Button:-
        var btn: Button =findViewById(R.id.btnSubmit)

        //SurName:-
        var uSurName: EditText =findViewById(R.id.editSnm)

        //Name:-
        var uName: EditText =findViewById(R.id.editNm)

        //Password:-
        var uPassword:EditText=findViewById(R.id.editPass)

        //Email:
        var email: EditText =findViewById(R.id.editMail)
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches())
                {
                    btn.isEnabled=false
                    email.setError("Invalid Input")
                }
                else
                {
                    btn.isEnabled=true
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }


        })

        //City:-
        var aCity: AutoCompleteTextView =findViewById(R.id.aCtvCity)
        var city= arrayOf("Ahemdabad ","Rajkot","Jamnagar","Baroda","Surat","Junagadh","Morabi")
        var adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        aCity.setAdapter(adapter)


        //Date:-
        var etDate: EditText =findViewById(R.id.editDob)
        var c= Calendar.getInstance()

        etDate.setOnClickListener {
            DatePickerDialog(this, 
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    etDate.setText("$dayOfMonth/${month+1}/$year")
                },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Gender:--
        var str:String=""
        var eGender: RadioGroup =findViewById(R.id.rbGen)
        eGender.setOnCheckedChangeListener{ radioGroup,i->
            var rb=findViewById<RadioButton>(i)
            str=rb.text.toString()
        }


        var sp=application.getSharedPreferences("login", Context.MODE_PRIVATE)
        var editor=sp.edit()
       //Intent:-
        btn.setOnClickListener {


            editor.putString("surname",uSurName.text.toString())
            editor.putString("name",uName.text.toString())
            editor.putString("email",email.text.toString())
            editor.putString("password",uPassword.text.toString())
            editor.putString("date",etDate.text.toString())
            editor.putString("city",aCity.text.toString())
            editor.putString("gender",str)

            editor.commit()

            uSurName.setText("")
            uName.setText("")
            email.setText("")
            uPassword.setText("")
            etDate.setText("")
            aCity.setText("")


            var i= Intent(this,FourActivity::class.java)
            startActivity(i)
        }

        //Shared pref:




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}