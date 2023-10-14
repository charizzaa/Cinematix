package com.example.cinematix

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class front : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity after the delay
            startActivity(Intent(this@front, MainActivity::class.java))
            finish() // Close the splash screen activity
        }, 3000)
    }
}