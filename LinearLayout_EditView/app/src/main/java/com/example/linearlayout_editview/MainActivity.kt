package com.example.linearlayout_editview

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.MultiAutoCompleteTextView.Tokenizer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Time:
        var etTime:EditText=findViewById(R.id.editTextTime)
        
        //Date:-
        var etDate:EditText=findViewById(R.id.editTextDate)
        var c=Calendar.getInstance()

        //Email:
        var email:EditText=findViewById(R.id.editTextTextEmailAddress)
        var btn:Button=findViewById(R.id.button)
        email.addTextChangedListener(object :TextWatcher{
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
        //Date:-
        etDate.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                etDate.setText("$dayOfMonth/${month+1}/$year")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }
        
        //Time:
        etTime.setOnClickListener { 
            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                etTime.setText("$hour:$minute")
            },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),true).show()
        }
        //AutoCompleteTextView:-
        var aCity: AutoCompleteTextView =findViewById(R.id.auto)
        var city= arrayOf("Rajkot","Surat","Ahemdabad","Jamnagar","Baroda")
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,city)
        aCity.setAdapter(adapter)


        //MultiAutoCompleteTextView:-
        var amcSkill: MultiAutoCompleteTextView =findViewById(R.id.multi)
        var skill= arrayOf("Web Design","Web Develop","Android App","UI-UX","Flutter","SEO")
        var skilladapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,skill)
        amcSkill.setAdapter(skilladapter)
        amcSkill.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}