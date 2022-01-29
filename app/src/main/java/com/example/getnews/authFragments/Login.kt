package com.example.getnews.authFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.getnews.FragmentsActivity
import com.example.getnews.PasswordResetActivity
import com.example.getnews.R
import com.google.firebase.auth.FirebaseAuth

class Login: Fragment(R.layout.activity_login) {
    private lateinit var editTextLoginEmail: EditText
    private lateinit var editTextLoginPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegistration: Button
    private lateinit var buttonResetPassword: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextLoginEmail = view.findViewById(R.id.editTextLoginEmail)
        editTextLoginPassword = view.findViewById(R.id.editTextLoginPassword)
        buttonLogin = view.findViewById(R.id.buttonLogin)
        buttonRegistration = view.findViewById(R.id.buttonRegistration)
        buttonResetPassword = view.findViewById(R.id.buttonResetPassword)

        if (FirebaseAuth.getInstance().currentUser != null) {
            goToFragments()
        }

        clickListeners()
    }


    private fun clickListeners() {
        buttonRegistration.setOnClickListener {
            startActivity(Intent(context, Register::class.java))
        }

        buttonResetPassword.setOnClickListener {
            startActivity(Intent(context, PasswordResetActivity::class.java))
        }

        buttonLogin.setOnClickListener {
            val email = editTextLoginEmail.text.toString()
            val password = editTextLoginPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        goToFragments()
                    } else {
                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

    private fun goToFragments() {
        startActivity(Intent(context, FragmentsActivity::class.java))
    }
}