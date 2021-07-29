package com.example.daterangepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daterangepicker.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CreateTripBtn.setOnClickListener {
            showDateRangePicker()
        }
    }
    private fun showDateRangePicker()
    {
        val dateRangePicker = MaterialDatePicker.Builder
                .dateRangePicker()
                .setTitleText("Select Date")
                .build()

        dateRangePicker.show(
                supportFragmentManager,
                "date_range_picker"
        )

        dateRangePicker.addOnPositiveButtonClickListener { datePicked->

            val startDate = datePicked.first
            val endDate = datePicked.second

            if (startDate != null && endDate != null) {

                binding.tvDateRange.text =
                        "StartDate:" + convertLongToDate(startDate)+
                "\nEndDate:"+ convertLongToDate(endDate)
            }
        }
    }
    private fun convertLongToDate(time:Long):String{
        val date = Date(time)
        val format = SimpleDateFormat(
                "dd-MM-yyyy",
                Locale.getDefault())
        return format.format(date)
    }
}