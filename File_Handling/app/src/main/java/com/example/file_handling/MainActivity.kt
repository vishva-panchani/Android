package com.example.file_handling

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var ed_text:EditText=findViewById(R.id.editTextText)
        var btn_write:Button=findViewById(R.id.button)
        var btn_read:Button=findViewById(R.id.button2)

        var builder=AlertDialog.Builder(this)
        btn_write.setOnClickListener {
            var fop = openFileOutput("myFile", Context.MODE_PRIVATE)
            fop.write(ed_text.text.toString().toByteArray())
            builder.setTitle("FILE HANDLING")
            builder.setMessage("Your data Saved!!!")
            builder.setPositiveButton("OK",DialogInterface.OnClickListener{  DialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNegativeButton("CANCEL",DialogInterface.OnClickListener{  DialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener{  DialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.show()
            ed_text.setText("")
        }

        //READ:---
        btn_read.setOnClickListener {
            var line:String?=""
            var fip=application.openFileInput("myFile")
            var br=BufferedReader(InputStreamReader(fip))
            while (line != null)
            {
                line=br.readLine()
                if (line != null)
                {
                    ed_text.append(line+"\n")
                }
            }
            builder.setTitle("FILE HANDLING")
            builder.setMessage("Your data Saved!!!")
            builder.setPositiveButton("OK",DialogInterface.OnClickListener{  DialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNegativeButton("CANCEL",DialogInterface.OnClickListener{  DialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener{  DialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.show()
            ed_text.setText("")


        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}