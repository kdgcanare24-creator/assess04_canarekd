package com.example.assess04_canarekd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)
        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val name = intent.getStringExtra("name")
        val birthdate = intent.getStringExtra("birthdate")
        val gender = intent.getStringExtra("gender")

        // Prefix based on gender
        val prefix = if (gender == "Female") "Ms. " else "Mr. "

        // Calculate age
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        var age = 0
        try {
            val dob = sdf.parse(birthdate!!)
            val today = Calendar.getInstance()
            val birthCal = Calendar.getInstance()
            birthCal.time = dob!!
            age = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR)
            if (today.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
                age--
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        textViewGreeting.text = "Hi $prefix$name"
        textViewAge.text = "Your Age is: $age"

        // Back button
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
