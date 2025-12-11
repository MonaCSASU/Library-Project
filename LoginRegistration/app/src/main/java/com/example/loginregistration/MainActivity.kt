package com.example.loginregistration

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.example.loginregistration.ui.theme.LoginRegistrationTheme
import com.google.firebase.auth.FirebaseAuth


class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        enableEdgeToEdge()
        setContent {
            LoginRegistrationTheme {
                val context = LocalContext.current
                val intent = Intent(context, LoginActivity::class.java)

                context.startActivity(intent)
            }
        }
    }
}

