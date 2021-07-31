package com.example.codehero_objective

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
public class ServicoWEB private constructor(){
//<uses-permition android:name= "android.permission.INTERNET"/>

    companion object{

        private lateinit var retrofit: Retrofit
        private val baseUrl = "https://gateway.marvel.com/"

        fun getRetrofitInstance():Retrofit{
            val httpClient = OkHttpClient.Builder()

            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <S> createService(serviceClass: Class<S>):S{
            return getRetrofitInstance().create(serviceClass)
        }
    }
}