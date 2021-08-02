package com.example.codehero_objective

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codehero_objective.databinding.FragmentSeriesMarvelBinding
import com.example.codehero_objective.network.Endpoint
import com.example.codehero_objective.network.ModeloHeroi
import com.example.codehero_objective.network.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SeriesMarvel : Fragment() {

    private var binding:FragmentSeriesMarvelBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeriesMarvelBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var heroi1 = HeroiModelo("Tony Stark", R.drawable.tony, "Demonio na Garrafa", "Guerra Infinita")
        var listaHerois = listOf(heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,)
        val adapterSeries = AdapterHeroi(listaHerois)
        binding?.let {
            with(it){
                recycleDadosHeroi.layoutManager = LinearLayoutManager(context)
                recycleDadosHeroi.adapter = adapterSeries
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}