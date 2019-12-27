package com.example.practicalexcersice4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener(){
            val c:Calendar = Calendar.getInstance()
            val CurrentDay = c.get(Calendar.DAY_OF_MONTH)
            val CurrentMonth = c.get(Calendar.MONTH)
            val CurrentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                txtDOB.setText(dayOfMonth.toString()+"/"+month.toString()+"/"+ year.toString())
                val Age = CurrentYear - year
                val minSaving = getString(Age)
                val invesment = minSaving.toDouble()*0.30

                txtAge.setText(Age.toString())
                txtBasicSaving.setText(minSaving.toString())
                txtAllowableInvestment.setText(invesment.toString())

            },CurrentYear,CurrentMonth,CurrentDay)
            dpd.show()

        }
    }
}
