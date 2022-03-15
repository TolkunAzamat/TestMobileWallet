package com.example.testmobilewallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testmobilewallet.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
        private lateinit var binding: ActivityHomeBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val navView: BottomNavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            navView.setupWithNavController(navController)
        }


    }
