package com.example.animation_framebyframe

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var ad=AnimationDrawable()

        var frame1=resources.getDrawable(R.drawable.frame1,null)
        var frame2=resources.getDrawable(R.drawable.frame2,null)
        var frame3=resources.getDrawable(R.drawable.frame3,null)
        var frame4=resources.getDrawable(R.drawable.frame4,null)
        var frame5=resources.getDrawable(R.drawable.frame5,null)
        var frame6=resources.getDrawable(R.drawable.frame6,null)
        var frame7=resources.getDrawable(R.drawable.frame7,null)

        ad.addFrame(frame1,60)
        ad.addFrame(frame2,60)
        ad.addFrame(frame3,60)
        ad.addFrame(frame4,60)
        ad.addFrame(frame5,60)
        ad.addFrame(frame6,60)
        ad.addFrame(frame7,60)

        var iv:ImageView=findViewById(R.id.imageView)
        iv.background=ad
        ad.start()
    }
}