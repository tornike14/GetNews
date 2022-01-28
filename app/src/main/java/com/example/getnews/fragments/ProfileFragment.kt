package com.example.getnews.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.getnews.ChangePasswordActivity
import com.example.getnews.LoginActivity
import com.example.getnews.R
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var textViewUserId: TextView
    private lateinit var buttonLogout: Button
    private lateinit var buttonChangePassword: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewUserId = view.findViewById(R.id.textViewUserId)
        buttonLogout = view.findViewById(R.id.buttonLogout)
        buttonChangePassword = view.findViewById(R.id.buttonChangePassword)

        profileListeners()

        textViewUserId.text = FirebaseAuth.getInstance().currentUser?.email
    }

    private fun profileListeners() {
        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context, LoginActivity::class.java))
        }

        buttonChangePassword.setOnClickListener {
            startActivity(Intent(context, ChangePasswordActivity::class.java))
        }
    }
}