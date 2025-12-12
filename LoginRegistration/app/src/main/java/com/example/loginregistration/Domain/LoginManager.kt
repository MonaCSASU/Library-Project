package com.example.loginregistration.Domain

import com.example.loginregistration.Data.AuthRepository

class LoginManager(private val authRepository: AuthRepository) {
    fun validateAndLogin(email: String, pass: String, onResult: (String) -> Unit) {

        if (email.isEmpty() || pass.isEmpty()) {
            onResult("Please fill all fields")
            return
        }

        authRepository.loginUser(email, pass) { userId ->
            if (userId != null) {

                authRepository.getUserRole(userId) { role ->
                    if (role == "Admin") {

                        onResult("AdminSuccess")

                    } else {

                        onResult("UserSuccess")

                    }

                }

            } else {

                onResult("Login Failed")

            }
        }
    }
}