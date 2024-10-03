package com.example.optionmenu_contextmenu

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var tv1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1=findViewById(R.id.textview1)
        registerForContextMenu(tv1)

    }
    //option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(101,1001,1,"New Group")
        menu?.add(102,1002,2,"New Broadcast")
        menu?.add(103,1003,3,"Linked Device")
        menu?.add(104,1004,4,"Payments")
        menu?.add(105,1005,5,"Setting")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            1001-> Toast.makeText(applicationContext, "New Group !!!!", Toast.LENGTH_LONG).show()
            1002-> Toast.makeText(applicationContext, "New Broadcast!!!!", Toast.LENGTH_LONG).show()
            1003-> tv1.textSize=40f
            1005-> {
                startActivity(Intent(this,SettingActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //context menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        menu?.setHeaderTitle("Choose Color")
        menu?.add(101,1111,1,"RED")
        menu?.add(103,1112,2,"GREEN")
        menu?.add(104,1113,3,"BLUE")
        menu?.add(105,1114,4,"CYAN")
        menu?.add(106,1115,5,"YELLOW")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            1111->tv1.setTextColor(Color.RED)
            1112->tv1.setTextColor(Color.GREEN)
            1113->tv1.setTextColor(Color.BLUE)
            1114->tv1.setTextColor(Color.CYAN)
            1115->tv1.setTextColor(Color.YELLOW)

        }
        return super.onContextItemSelected(item)
    }
}