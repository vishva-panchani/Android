package com.example.video_capture

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var videoView: VideoView
    lateinit var b1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        b1=findViewById(R.id.button)
        videoView=findViewById(R.id.videoView)

        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!=
            PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf( android.Manifest.permission.CAMERA),101)
        }else
        {
            b1.isEnabled=true

        }
        b1.setOnClickListener {
            var i=Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(i,222)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

          if (requestCode==101){
              videoView.setVideoURI(data?.data)
              videoView.start()

          }
        }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==222 && grantResults[0]===PackageManager.PERMISSION_GRANTED){
            b1.isEnabled=true
        }
    }
}
