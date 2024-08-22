package com.example.registrationapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.PasswordAuthentication
import java.util.Calendar

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        //Submit Button:-
        var btn: Button =findViewById(R.id.button)

        //Name:-
        var uName:EditText=findViewById(R.id.editTextText1)

        //Email:
        var email: EditText =findViewById(R.id.editTextText3)
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
        var aCity: AutoCompleteTextView =findViewById(R.id.autoCompleteTextView)
        var city= arrayOf("Ahemdabad ","Rajkot","Jamnagar","Baroda","Surat","Junagadh","Morabi")
        var adapter= ArrayAdapter<String>(this,R.layout.customelayout,city)
        aCity.setAdapter(adapter)


        //Hobby:-
        var amcHobby: MultiAutoCompleteTextView =findViewById(R.id.multiAutoCompleteTextView)
        var hobby= arrayOf("Reading","Writing","Cooking","Travelling","Drawing","Singing")
        var skilladapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,hobby)
        amcHobby.setAdapter(skilladapter)
        amcHobby.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


        //Date:-
        var etDate: EditText =findViewById(R.id.editTextText7)
        var c= Calendar.getInstance()

        etDate.setOnClickListener {
            DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    etDate.setText("$dayOfMonth/${month+1}/$year")
                },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Gender:--
        var str:String=""
        var eGender:RadioGroup=findViewById(R.id.radioGroup)
        eGender.setOnCheckedChangeListener{ radioGroup,i->
            var rb=findViewById<RadioButton>(i)
           str=rb.text.toString()
        }

        //Intent:-
        btn.setOnClickListener {
            var i=Intent(this,ThirdActivity::class.java)
            i.putExtra("name",uName.text.toString())
            i.putExtra("email",email.text.toString())
            i.putExtra("hobbies",amcHobby.text.toString())
            i.putExtra("city",aCity.text.toString())
            i.putExtra("gender",str)
            i.putExtra("date",etDate.text.toString())
            startActivity(i)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}