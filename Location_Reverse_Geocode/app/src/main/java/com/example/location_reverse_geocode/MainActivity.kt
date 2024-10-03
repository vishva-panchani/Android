package com.example.location_reverse_geocode

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var  lm:LocationManager
    lateinit var loc:Location
    lateinit var tv2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tv2 = findViewById(R.id.textview2)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                111
            )
        }

        lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        var ll = object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                reverseGeocode(p0)
            }
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 100.2f, ll)
    }
    private fun reverseGeocode(loc: Location?) {
        var gc= Geocoder(this,Locale.getDefault())
        var addresses=gc.getFromLocation(loc!!.latitude,loc.longitude,2)
        var address = addresses?.get(0)
        if (address != null) {
            tv2.setText("${address.getAddressLine(0)}\n${address.locality}")
        }

        }
    }

