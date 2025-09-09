package com.example.assess04_canarekd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextBirthdate = findViewById<EditText>(R.id.editTextBirthdate)
        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val name = editTextName.text.toString()
            val birthdate = editTextBirthdate.text.toString()
            val gender = spinnerGender.selectedItem.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("birthdate", birthdate)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }
}
