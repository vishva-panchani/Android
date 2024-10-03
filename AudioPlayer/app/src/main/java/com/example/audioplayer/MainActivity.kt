package com.example.audioplayer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btnaudio:Button
    lateinit var btnstop:Button
    lateinit var btnaudio1:Button
    lateinit var btnstop1:Button
    lateinit var mp:MediaPlayer


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnaudio=findViewById(R.id.buttonAudio)
        btnstop=findViewById(R.id.buttonStop)
        btnaudio1=findViewById(R.id.buttonAudio1)
        btnstop1=findViewById(R.id.buttonStop1)

        //offline
        btnaudio.setOnClickListener {
            mp=MediaPlayer.create(this,R.raw.musicaudio)
            mp.start()

        }
        btnstop.setOnClickListener {
            mp.stop()
        }

        //online
        btnaudio1.setOnClickListener {
            mp= MediaPlayer()

            mp.setDataSource(this, Uri.parse("https://codeskulptor-demos.commondatastorage.googleapis.com/pang/paza-moduless.mp3"))
            mp.prepare()
            mp.start()
        }
        btnstop1.setOnClickListener {
            mp.stop()
        }
    }
}