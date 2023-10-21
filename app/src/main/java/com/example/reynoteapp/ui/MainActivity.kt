package com.example.reynoteapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reynoteapp.R
import com.example.reynoteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}