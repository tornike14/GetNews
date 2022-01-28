package com.example.getnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var editTextResetPasswordEmail: EditText
    private lateinit var buttonResetPasswordA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        init()
        ResetPasswordListeners()
    }

    private fun init() {
        editTextResetPasswordEmail = findViewById(R.id.editTextResetPasswordEmail)
        buttonResetPasswordA = findViewById(R.id.buttonResetPasswordA)
    }

    private fun ResetPasswordListeners() {
        buttonResetPasswordA.setOnClickListener {
            val email = editTextResetPasswordEmail.text.toString()

            if(email.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Check Email!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}