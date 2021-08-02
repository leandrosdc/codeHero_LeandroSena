package com.example.codehero_objective

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codehero_objective.databinding.FragmentBuscaMarvelBinding
import com.example.codehero_objective.databinding.FragmentEventoMarvelBinding


class EventoMarvel : Fragment() {

    private var binding:FragmentEventoMarvelBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventoMarvelBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var heroi1 = HeroiModelo("Tony Stark", R.drawable.tony, "Demonio na Garrafa", "Guerra Infinita")
        var listaEventos = listOf(heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,heroi1,)
        val adapterEventos = AdapterHeroi(listaEventos)
        binding?.let {
            with(it){
                recycleDadosHeroi.layoutManager = LinearLayoutManager(context)
                recycleDadosHeroi.adapter = adapterEventos
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}