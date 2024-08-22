package com.example.task_1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeekBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seek_bar)

        var rb: RatingBar =findViewById(R.id.ratingBar)
        var tv1: TextView =findViewById(R.id.textView)

        rb.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            tv1.setText("Rating Value:$rating")
        }

        var sb: SeekBar =findViewById(R.id.seekBar)
        var tv2: TextView =findViewById(R.id.textView4)



        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tv2.setText("SeekBar Value:$progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

//        var revbtn:ImageButton=findViewById(R.id.imageButton)
//        revbtn.setOnClickListener {
//            var i = Intent(this,MainActivity::class.java)
//            startActivity(i)
//        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}