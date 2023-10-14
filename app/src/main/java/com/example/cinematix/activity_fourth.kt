package com.example.cinematix

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cinematix.databinding.ActivityFourthBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class activity_fourth : AppCompatActivity(){
    private lateinit var binding: ActivityFourthBinding
    private lateinit var dateChosen: TextView
    private lateinit var timeChosen: TextView
    var totalPayment = 0

    companion object{
        const val EXTRA_CINEMA = "extra_cinema"
        const val EXTRA_SEAT = "extra_seat"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_TIME = "extra_time"
        const val EXTRA_PAYMENT = "extra_payment"
        const val EXTRA_SEATNUMBER = "extra_seatnumber"
        const val EXTRA_TOTAL = "extra_total"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cinema = arrayOf(
            "Ambarrukmo XXI",
            "Empire XXI",
            "Jogja City XXI",
            "JWALK MALL CGV",
            "Lippo Plaza Jogja Cinepolis",
            "Pakuwon Mall Jogja CGV",
            "Sleman City Hall XXI",
            "Transmart Maguwo CGV"
        )

        val seat = arrayOf(
            "Regular",
            "Premium",
            "VIP",
            "VVIP"
        )

        val payment = arrayOf(
            "Bank Transfer",
            "QRIS",
            "On Site"
        )

        with(binding){
            val cinemaAdapter = ArrayAdapter(this@activity_fourth, android.R.layout.simple_spinner_dropdown_item, cinema)
            cinemaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spincinema.adapter = cinemaAdapter

            val seatAdapter = ArrayAdapter(this@activity_fourth, android.R.layout.simple_spinner_dropdown_item, seat)
            seatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinseat.adapter = seatAdapter

            val paymentAdapter = ArrayAdapter(this@activity_fourth, android.R.layout.simple_spinner_dropdown_item, payment)
            paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinpayment.adapter = paymentAdapter

            spinseat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val seat = when (spinseat.selectedItem.toString()){
                        "Regular" -> 35000
                        "Premium" -> 50000
                        "VIP" -> 75000
                        "VVIP" -> 100000
                        else -> 0
                    }

                    val numberOfSeats = seatvalue.text.toString()

                    if (numberOfSeats.isNotEmpty()) {
                        val numberOfSeats = numberOfSeats.toInt()
                        totalPayment = seat * numberOfSeats
                        seatcount.text = " X "+ numberOfSeats.toString()
                        kindseat.text = spinseat.selectedItem.toString()
                        total.text = totalPayment.toString()
                        totalseat.text = seat.toString()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case where no seat is selected (if necessary)
                }
                }
            selectDate.setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    this@activity_fourth,
                    DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                        selectedDate.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year) }, year, month, day)
                dpd.show()
            }
            selectTime.setOnClickListener {
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@activity_fourth,
                    TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                        selectedTime.text = String.format("%02d:%02d", selectedHour, selectedMinute) }, hour, minute,
                    false
                )
                timePickerDialog.show()
            }



            back.setOnClickListener(){
                val intentThird = Intent(this@activity_fourth, activity_third::class.java)
                startActivity(intentThird)
            }
            buyticket.setOnClickListener{
                val message = "Payment Success"
                Toast.makeText(this@activity_fourth, message, Toast.LENGTH_SHORT).show()
                val intentFifth = Intent(this@activity_fourth, activity_fifth::class.java)
                intentFifth.putExtra(EXTRA_CINEMA,spincinema.selectedItem.toString())
                intentFifth.putExtra(EXTRA_SEAT,spinseat.selectedItem.toString())
                intentFifth.putExtra(EXTRA_PAYMENT, spinpayment.selectedItem.toString())
                intentFifth.putExtra(EXTRA_SEATNUMBER,seatvalue.text.toString())
                intentFifth.putExtra(EXTRA_TOTAL,totalPayment.toString())
                intentFifth.putExtra(EXTRA_DATE,selectedDate.text.toString())
                intentFifth.putExtra(EXTRA_TIME,selectedTime.text.toString())
                startActivity(intentFifth)
            }
            }
        }
    }
