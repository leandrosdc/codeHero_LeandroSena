package com.example.codehero_objective

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codehero_objective.databinding.RecyclerlistaheroiBinding

class AdapterHeroi(private val listaHeroi:List<HeroiModelo>):RecyclerView.Adapter<AdapterHeroi.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHeroi.ViewHolder {
        val binding = RecyclerlistaheroiBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterHeroi.ViewHolder, position: Int) {
        holder.bind(listaHeroi[position])
    }

    override fun getItemCount() = listaHeroi.size

    class ViewHolder(val binding:RecyclerlistaheroiBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(heroi:HeroiModelo){
            binding.ImgViewHeroi.setImageResource(heroi.fotoHeroi)
            binding.TxtViewNomeHeroi.text = heroi.nomeHeroi
        }
    }
}