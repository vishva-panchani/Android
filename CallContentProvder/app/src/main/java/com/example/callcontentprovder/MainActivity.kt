package com.example.callcontentprovder

import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.CallLog
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var cols= arrayOf(CallLog.Calls.NUMBER,CallLog.Calls.DURATION,CallLog.Calls._ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CALL_LOG),117)
        }else{
            readCalllog()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray)
     {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         if (requestCode==117&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
             readCalllog()
         }
    }

    private fun readCalllog()
    {
        var rs=contentResolver.query(CallLog.Calls.CONTENT_URI,cols,null,null,null)
        var adapter= SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,cols,
            intArrayOf(android.R.id.text1,android.R.id.text2)
        )
        var lv:ListView=findViewById(R.id.listview)
        lv.adapter=adapter
    }
}
