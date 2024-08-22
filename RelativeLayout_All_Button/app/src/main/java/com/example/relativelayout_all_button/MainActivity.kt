package com.example.relativelayout_all_button

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btn:Button=findViewById(R.id.button)
        var imgbtn:ImageButton=findViewById(R.id.imageButton)
        var tglbtn:ToggleButton=findViewById(R.id.toggleButton)
        var imgview:ImageView=findViewById(R.id.imageView)
        var fab:FloatingActionButton=findViewById(R.id.floatingActionButton)


        btn.setOnClickListener{
            Toast.makeText(applicationContext,"Simple Button",Toast.LENGTH_LONG).show()
        }
        imgbtn.setOnClickListener{
            Toast.makeText(applicationContext,"Image Button",Toast.LENGTH_LONG).show()
        }

        tglbtn.setOnClickListener{
            if(tglbtn.text.equals("ON"))
            {
                imgview.setImageResource(R.drawable.off)
            }else
            {
                imgview.setImageResource(R.drawable.on)
            }

        }

        fab.setOnClickListener {
            Toast.makeText(applicationContext,"Add Item",Toast.LENGTH_LONG).show()
        }

        var ch1:CheckBox=findViewById(R.id.checkBox1)
        var ch2:CheckBox=findViewById(R.id.checkBox2)
        var ch3:CheckBox=findViewById(R.id.checkBox3)
        var str:String
        var textview:TextView=findViewById(R.id.textView1)

        ch1.setOnClickListener {
            str="JAVA : ${ch1.isChecked}\nKOTLIN:${ch2.isChecked}\nANDROID:${ch3.isChecked}"
            textview.setText(str)
        }
        ch2.setOnClickListener {
            str="JAVA : ${ch1.isChecked}\nKOTLIN:${ch2.isChecked}\nANDROID:${ch3.isChecked}"
            textview.setText(str)
        }
        ch3.setOnClickListener {
            str="JAVA : ${ch1.isChecked}\nKOTLIN:${ch2.isChecked}\nANDROID:${ch3.isChecked}"
            textview.setText(str)
        }


        var rg:RadioGroup=findViewById(R.id.radioGroup)
        var tv2:TextView=findViewById(R.id.textView2)
        var resetBtn: Button =findViewById(R.id.button2)

        rg.setOnCheckedChangeListener{ radioGroup,i->
            var rb=findViewById<RadioButton>(i)
            if(rb!=null)
            {
                tv2.setText(rb.text)
            }
        }

        resetBtn.setOnClickListener {
            rg.clearCheck()
            tv2.setText("Select Option")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}