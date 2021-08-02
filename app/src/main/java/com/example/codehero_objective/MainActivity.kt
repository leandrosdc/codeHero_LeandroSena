package com.example.codehero_objective

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.codehero_objective.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}


//"https://gateway.marvel.com:443/"
//@GET("v1/public/characters?ts=1627780458&apikey=3fe17c241dedecfe5db1c099840217f1&hash=ad72d7fb8e25bf1ca9594d664e681d20")
//<uses-permission android:name="android.permission.INTERNET" />
//<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />