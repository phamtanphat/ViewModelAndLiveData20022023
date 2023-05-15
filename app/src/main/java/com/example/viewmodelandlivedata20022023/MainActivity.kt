package com.example.viewmodelandlivedata20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var txtNumber: TextView
    private lateinit var btnRandomNumber: Button
    private var mutableLiveDataNumber: MutableLiveData<Int> = MutableLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNumber = findViewById(R.id.text_view_number)
        btnRandomNumber = findViewById(R.id.buttom_random)

        mutableLiveDataNumber.observe(this) { number ->
            txtNumber.text = number.toString()
        }

        btnRandomNumber.setOnClickListener {
            val number = Random.nextInt(100)
            mutableLiveDataNumber.value = number
        }
    }
}
