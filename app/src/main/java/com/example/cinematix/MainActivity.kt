package com.example.cinematix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cinematix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val EXTRA_USERNAME = "extra_username"
    }

    private val usernameIn = "Caca"
    private val passwordIn = "503754"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            loginBtn.setOnClickListener{
                val usernameMasuk = username.text.toString()
                val passwordMasuk = password.text.toString()
                if (usernameMasuk == usernameIn && passwordMasuk == passwordIn) {
                    val intentSecond = Intent(this@MainActivity, activity_second::class.java)
                    intentSecond.putExtra(EXTRA_USERNAME, usernameMasuk)
                    startActivity(intentSecond)
                } else {
                    Toast.makeText(this@MainActivity, "Incorrect username or password.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
    }
