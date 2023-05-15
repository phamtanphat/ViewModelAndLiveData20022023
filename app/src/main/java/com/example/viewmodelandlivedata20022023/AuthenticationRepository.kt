package com.example.viewmodelandlivedata20022023

import android.content.Context

/**
 * Created by pphat on 5/15/2023.
 */
class AuthenticationRepository(var sharePreferenceApp: SharePreferenceApp) {

    fun login(email: String, password: String, isSaved: Boolean): Boolean {
        if (email == "abc@gmail.com" && password == "12345678") {
            saveAccount(email, password, isSaved)
            return true
        }
        return false
    }

    private fun saveAccount(
        email: String,
        password: String,
        isSaved: Boolean
    ) {
        if (isSaved) {
            sharePreferenceApp
                .setStringValue("email", email)
                .setStringValue("password", password)
                .setBooleanValue("isSaved", true)
                .apply()

        } else {
            sharePreferenceApp.clear()
        }
    }
}
