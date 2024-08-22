package com.example.task_1

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
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        //Email:
        var email: EditText =findViewById(R.id.editTextMail)
        var btn: Button =findViewById(R.id.button5)
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

        //AutoCompleteTextView:-
        var aUni: AutoCompleteTextView =findViewById(R.id.autoCompleteTextView)
        var uni= arrayOf("Atmiya University ","RK University","Marwadi University","MS University","Darshan University")
        var adapter= ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,uni)
        aUni.setAdapter(adapter)


        //MultiAutoCompleteTextView:-
        var amcSkill: MultiAutoCompleteTextView =findViewById(R.id.multiAutoCompleteTextView)
        var skill= arrayOf("Web Design","Web Develop","Android App","UI-UX","Flutter","SEO")
        var skilladapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,skill)
        amcSkill.setAdapter(skilladapter)
        amcSkill.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


        //Date:-
        var etDate:EditText=findViewById(R.id.textDate)
        var c=Calendar.getInstance()

        etDate.setOnClickListener {
            DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                etDate.setText("$dayOfMonth/${month+1}/$year")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Time:
        var etTime:EditText=findViewById(R.id.textTime)

        etTime.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                etTime.setText("$hour:$minute")
            },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),true).show()
        }



        btn.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}