package com.example.viewmodelandlivedata20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var checkBoxRemember: CheckBox
    private lateinit var btnLogin: Button
    private lateinit var authenticationRepository: AuthenticationRepository
    private lateinit var sharePreferenceApp: SharePreferenceApp
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        observerData()
        eventView()
    }

    private fun observerData() {
        viewModel.getLiveDataMessage().observe(this) {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getLiveDataUser().observe(this) {
            edtEmail.setText(it.first)
            edtPassword.setText(it.second)
            checkBoxRemember.isChecked = it.third
        }
    }

    private fun eventView() {
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val isSaved = checkBoxRemember.isChecked
            viewModel.login(email, password, isSaved)
        }

        viewModel.getDataUser()
    }

    private fun initView() {
        edtEmail = findViewById(R.id.edit_text_email)
        edtPassword = findViewById(R.id.edit_text_password)
        checkBoxRemember = findViewById(R.id.check_box_save)
        btnLogin = findViewById(R.id.button_login)

        sharePreferenceApp = SharePreferenceApp(this)
        authenticationRepository = AuthenticationRepository(sharePreferenceApp)
        viewModel = ViewModelProvider(this@MainActivity, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return MainViewModel(authenticationRepository) as T
            }
        })[MainViewModel::class.java]
    }
}
