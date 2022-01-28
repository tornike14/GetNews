package com.example.getnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var textViewUserId: TextView
    private lateinit var buttonLogout: Button
    private lateinit var buttonChangePassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        profileListeners()

        textViewUserId.text = FirebaseAuth.getInstance().currentUser?.uid
    }

    private fun init() {
        textViewUserId = findViewById(R.id.textViewUserId)
        buttonLogout = findViewById(R.id.buttonLogout)
        buttonChangePassword = findViewById(R.id.buttonChangePassword)
    }

    private fun profileListeners() {
        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        buttonChangePassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
    }
}