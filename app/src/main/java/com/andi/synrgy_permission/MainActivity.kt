package com.andi.synrgy_permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.andi.synrgy_permission.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        val image = binding.imageViewAtas
        val button = binding.buttonLoc
        setContentView(view)

        val imageUrl = "https://firebasestorage.googleapis.com/v0/b/jastip-21e34.appspot.com/o/kue%2FMamahkeMamahke%20Oecis.jpg?alt=media&token=537bae0f-ca76-4ff8-a0f5-eb78c24a8bc9"

        Glide.with(this)
                .load(imageUrl)
                .centerCrop()
                .into(image)

        button.setOnClickListener {
            getLoc()
        }
    }

    private fun getLoc(){
        val fusedLocation = LocationServices.getFusedLocationProviderClient(this)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show()
            Log.d("permission", "Location Permission Denied")
        }

        fusedLocation.lastLocation.addOnSuccessListener(this
        ) { location -> // Do it all with location
            Log.d("Location", "Lat : ${location?.latitude} Long : ${location?.longitude}")
            // Display in Toast
            Toast.makeText(this@MainActivity, "Longitude dan Latitude didapatkan ${location?.longitude}, ${location?.latitude} . Silakan Cek Logcat", Toast.LENGTH_LONG).show()
        }
    }
}