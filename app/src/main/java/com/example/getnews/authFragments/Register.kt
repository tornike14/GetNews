package com.example.getnews.authFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.getnews.FragmentsActivity
import com.example.getnews.R
import com.google.firebase.auth.FirebaseAuth

class Register: Fragment(R.layout.activity_registration) {

    private lateinit var editTextRegisterEmail: EditText
    private lateinit var editTextRegisterPassword: EditText
    private lateinit var buttonRegister: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextRegisterEmail = view.findViewById(R.id.editTextRegisterEmail)
        editTextRegisterPassword = view.findViewById(R.id.editTextRegisterPassword)
        buttonRegister = view.findViewById(R.id.buttonRegister)

        RegistrationListeners()
    }

    private fun RegistrationListeners() {
        buttonRegister.setOnClickListener {
            val email = editTextRegisterEmail.text.toString()
            val password = editTextRegisterPassword.text.toString()

            if(email.isEmpty() || (password.isEmpty())) {
                Toast.makeText(context, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if(password.length < 8) {
                Toast.makeText(context, "Password isn't correct!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        startActivity(Intent(context, FragmentsActivity::class.java))
                    } else {
                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}