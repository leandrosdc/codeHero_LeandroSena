package com.example.codehero_objective.network

import com.google.gson.annotations.SerializedName

data class ModeloHeroi(
    @SerializedName("id")
    var id:Int? = 0 ,

    @SerializedName("name")
    var nomeHeroi:String? = "",

    @SerializedName("description")
    var descricaoHeroi:String? = "",

    @SerializedName("path")
    var caminhoImagem:String? = "",

    @SerializedName("extension")
    var extencaoImagem:String? = "",
){}