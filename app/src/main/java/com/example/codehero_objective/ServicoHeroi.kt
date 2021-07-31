package com.example.codehero_objective

import retrofit2.Call
import retrofit2.http.GET

interface ServicoHeroi {

    @GET("v1/public/characters")
    fun list():Call<List<HeroiModelo>>
}


