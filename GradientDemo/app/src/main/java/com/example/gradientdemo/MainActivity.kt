package com.example.gradientdemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.SweepGradient
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        setContentView(Test(applicationContext))

    }
    inner class Test(context: Context):View(context){
        var p=Paint(Paint.ANTI_ALIAS_FLAG)
        @SuppressLint("DrawAllocation")
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var lg=LinearGradient(10f,10f,30f,30f,Color.GREEN,Color.BLUE,Shader.TileMode.MIRROR)
            p.shader=lg
            canvas?.drawCircle(250f,250f,200f,p)

            var lg1=LinearGradient(10f,10f,60f,30f,Color.GREEN,Color.BLUE,Shader.TileMode.MIRROR)
            p.shader=lg1
            canvas?.drawCircle(800f,250f,200f,p)

            var rg=RadialGradient(500f,600f,150f,Color.RED,Color.BLACK,Shader.TileMode.MIRROR)
            p.shader=rg
            canvas?.drawCircle(250f,800f,200f,p)



            var sq=SweepGradient(200f,1400f, intArrayOf(Color.YELLOW,Color.GREEN,Color.MAGENTA),null)
            p.shader=sq
            canvas?.drawCircle(250f,1400f,200f,p)

        }
    }
}