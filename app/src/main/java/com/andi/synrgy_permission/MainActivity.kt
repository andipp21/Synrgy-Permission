package com.andi.synrgy_permission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageUrl = "https://firebasestorage.googleapis.com/v0/b/jastip-21e34.appspot.com/o/kue%2FMamahkeMamahke%20Oecis.jpg?alt=media&token=537bae0f-ca76-4ff8-a0f5-eb78c24a8bc9"

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/jastip-21e34.appspot.com/o/kue%2FMamahkeMamahke%20Oecis.jpg?alt=media&token=537bae0f-ca76-4ff8-a0f5-eb78c24a8bc9")
                .centerCrop()
                .into(imageView)
    }
}