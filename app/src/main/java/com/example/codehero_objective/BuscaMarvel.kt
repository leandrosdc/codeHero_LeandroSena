package com.example.codehero_objective

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codehero_objective.databinding.FragmentBuscaMarvelBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.NoSuchAlgorithmException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codehero_objective.network.Endpoint
import com.example.codehero_objective.network.ModeloHeroi
import com.example.codehero_objective.network.NetworkUtils
import retrofit2.Retrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
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

        val retrofitClient = NetworkUtils.getRetrofitInstance("https://gateway.marvel.com/v1/public/")
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()
        val callback2 = endpoint.getPosts2()



        callback2.enqueue(object : Callback<ModeloHeroi> {
            override fun onFailure(call: Call<ModeloHeroi>, t: Throwable) { t.message?.let { Log.i("TESTENOK2", it) } }
            override fun onResponse(call: Call<ModeloHeroi>, response: Response<ModeloHeroi>) {
                Log.i("TESTEOK2", response.message())
                //response.body()?.javaClass?.name?.forEach {
                Log.i("TESTEOK2", response.body().toString())
                //}
            }
        })

        callback.enqueue(object : Callback<ModeloListaHeroi> {
            override fun onFailure(call: Call<ModeloListaHeroi>, t: Throwable) { t.message?.let { Log.i("TESTENOK1", it) } }
            override fun onResponse(call: Call<ModeloListaHeroi>, response: Response<ModeloListaHeroi>) {
                response.body().let {
                    Log.i("TESTEOK1", response.message())
                    Log.i("TESTEOK1", response.body().toString())
                }
                }
        })

        var heroi1 = HeroiModelo("Tony Stark", R.drawable.tony, "Demonio na Garrafa", "Guerra Infinita")
        var listaHerois = listOf(heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,)
        val adapterHeroi = AdapterHeroi(listaHerois)
        binding?.let {
            with(it){
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

