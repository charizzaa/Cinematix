package com.example.cinematix

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cinematix.databinding.ActivityThirdBinding

class activity_third : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            back.setOnClickListener(){
                val intentSecond = Intent(this@activity_third, activity_second::class.java)
                startActivity(intentSecond)
            }
            getticket.setOnClickListener(){
                val intentFourth = Intent(this@activity_third, activity_fourth::class.java)
                startActivity(intentFourth)
            }
        }
    }
}