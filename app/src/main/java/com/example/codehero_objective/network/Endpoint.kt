package com.example.codehero_objective.network

import com.example.codehero_objective.ModeloListaHeroi
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("characters?ts=1627780458&apikey=3fe17c241dedecfe5db1c099840217f1&hash=ad72d7fb8e25bf1ca9594d664e681d20")
    fun getPosts(): Call<ModeloListaHeroi>

    @GET("characters?ts=1627780458&apikey=3fe17c241dedecfe5db1c099840217f1&hash=ad72d7fb8e25bf1ca9594d664e681d20")
    fun getPosts2(): Call<ModeloHeroi>
}