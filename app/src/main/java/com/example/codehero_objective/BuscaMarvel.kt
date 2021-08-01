package com.example.codehero_objective

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codehero_objective.databinding.FragmentBuscaMarvelBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class BuscaMarvel : Fragment() {

    private var binding:FragmentBuscaMarvelBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuscaMarvelBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //"https://gateway.marvel.com:443/"
        //@GET("v1/public/characters?ts=1627780458&apikey=3fe17c241dedecfe5db1c099840217f1&hash=ad72d7fb8e25bf1ca9594d664e681d20")
        //<uses-permission android:name="android.permission.INTERNET" />
        //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />


        var heroi1 = HeroiModelo("Tony 1", R.drawable.tony)
        var heroi2 = HeroiModelo("Tony 1", R.drawable.tony)
        var heroi3 = HeroiModelo("Tony 1", R.drawable.tony)
        var listaHerois = listOf<HeroiModelo>(heroi1,heroi2,heroi3,heroi1)
        val adapterHeroi = AdapterHeroi(listaHeroi = listaHerois)




        binding?.let {
            with(it){
                //txtBarraVermelha.text = getSuperHeroes()
                recycleDadosHeroi.layoutManager = LinearLayoutManager(context)
                recycleDadosHeroi.adapter = adapterHeroi
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}

