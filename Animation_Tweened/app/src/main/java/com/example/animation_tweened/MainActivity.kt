package com.example.animation_tweened

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            var iv:ImageView=findViewById(R.id.imageView)

            var b1:Button=findViewById(R.id.button)
            b1.setOnClickListener {
                var an=AnimationUtils.loadAnimation(this,R.anim.spin)
                iv.startAnimation(an)
            }


            var b2:Button=findViewById(R.id.button2)
            b2.setOnClickListener {
                var an=AnimationUtils.loadAnimation(this,R.anim.zoom)
                iv.startAnimation(an)
            }


            var b3:Button=findViewById(R.id.button3)
            b3.setOnClickListener {
                var an=AnimationUtils.loadAnimation(this,R.anim.move)
                iv.startAnimation(an)
            }


            var b4:Button=findViewById(R.id.button4)
            b4.setOnClickListener {
                var an=AnimationUtils.loadAnimation(this,R.anim.blink)
                iv.startAnimation(an)
            }

    }
}