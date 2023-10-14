package com.example.cinematix

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cinematix.databinding.ActivitySecondBinding

class activity_second : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username1 = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        with(binding) {
            username.text = username1
            showman.setOnClickListener {
                val intentThird = Intent(this@activity_second, activity_third::class.java)
                startActivity(intentThird)
            }
        }
    }
}