package com.example.codehero_objective

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codehero_objective.databinding.RecyclerlistaheroiBinding

class AdapterEventos(private val listaHeroi:List<HeroiModelo>): RecyclerView.Adapter<AdapterEventos.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerlistaheroiBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listaHeroi.size

    class ViewHolder(val binding: RecyclerlistaheroiBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(heroi: HeroiModelo){
            binding.TxtViewTexto.text = heroi.eventoHeroi
            binding.ImgViewHeroi.setImageResource(heroi.fotoHeroi)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaHeroi[position])
    }
}