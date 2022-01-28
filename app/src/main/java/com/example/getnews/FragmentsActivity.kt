package com.example.getnews

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val controller = findNavController(R.id.fl_wrapper)

        val appNavigationFragments = AppBarConfiguration(setOf(
            R.id.NewsFragment,
            R.id.ProfileFragment,
            R.id.SelectionsFragment,
        ))

        setupActionBarWithNavController(controller, appNavigationFragments)
        bottomNavigation.setupWithNavController(controller)
    }
}