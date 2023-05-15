package com.example.viewmodelandlivedata20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var txtNumber: TextView
    private lateinit var btnRandomNumber: Button
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this@MainActivity, "OnCreate", Toast.LENGTH_SHORT).show()

        txtNumber = findViewById(R.id.text_view_number)
        btnRandomNumber = findViewById(R.id.buttom_random)

        viewModel.getNumberLiveData().observe(this) { number ->
            txtNumber.text = number.toString()
        }

        btnRandomNumber.setOnClickListener {
            viewModel.randomNumber()
        }
    }
}
