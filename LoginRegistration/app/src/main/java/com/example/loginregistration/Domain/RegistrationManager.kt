package com.example.loginregistration.Domain

import com.example.loginregistration.Data.AuthRepository

class RegistrationManager(private val authRepository: AuthRepository) {

    fun validateAndRegister(email: String, pass: String, confirm: String, onResult: (String) -> Unit) {

        if (email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            onResult("Please fill all fields")
            return
        }

        if (pass != confirm) {

            onResult("Password and Confirm mismatch")
            return

        }

        authRepository.createUser(email, pass) { success ->
            if (success) {

                authRepository.saveUserData("mockUserId", email) { saved ->

                    if (saved) onResult("Success") else onResult("Save failed")

                }

            } else {

                onResult("Registration Failed")

            }
        }
    }
}