package com.example.cinematix

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cinematix.databinding.ActivityFifthBinding
import java.text.SimpleDateFormat
import java.util.Locale

class activity_fifth : AppCompatActivity(){
    private lateinit var binding: ActivityFifthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cinema = intent.getStringExtra("extra_cinema")
        val seat = intent.getStringExtra("extra_seat")
        val payment = intent.getStringExtra("extra_payment")
        val total = intent.getStringExtra("extra_total")
        val seatnumber = intent.getStringExtra("extra_seatnumber")
        val date = intent.getStringExtra("extra_date")

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateObj = sdf.parse(date)
        val formattedDate = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(dateObj)

        val time = intent.getStringExtra(activity_fourth.EXTRA_TIME)
        with(binding){
            cinematv.text = cinema
            seattv.text = seat
            paymenttv.text = payment
            totaltv.text = total
            totalseattv.text = seatnumber
            datetv.text = formattedDate
            timetv.text = time
            back.setOnClickListener(){
                val intentFourth = Intent(this@activity_fifth, activity_fourth::class.java)
                startActivity(intentFourth)
            }
        }
    }
}