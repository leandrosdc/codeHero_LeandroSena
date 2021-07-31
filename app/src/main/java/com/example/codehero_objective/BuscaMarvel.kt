package com.example.codehero_objective

import android.os.Bundle
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

        val remote = ServicoWEB.createService(ServicoHeroi::class.java)
        val call: Call<List<HeroiModelo>> = remote.list()
        val response = call.enqueue(object : Callback<List<HeroiModelo>>{

            override fun onResponse(call: Call<List<HeroiModelo>>, response: Response<List<HeroiModelo>>) {
                val s = response.body()
            }

            override fun onFailure(call: Call<List<HeroiModelo>>, t: Throwable) {
                val s = t.message
            }

        })

        var heroi1 = HeroiModelo("Tony 1", R.drawable.tony)
        var heroi2 = HeroiModelo("Tony 1", R.drawable.tony)
        var heroi3 = HeroiModelo("Tony 1", R.drawable.tony)
        var listaHerois = listOf<HeroiModelo>(heroi1,heroi2,heroi3,heroi1)
        val adapterHeroi = AdapterHeroi(listaHeroi = listaHerois)

        binding?.txtBarraVermelha?.text = MD5("Leandro")
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

    fun MD5(md5: String): String? {
        try {
            val md = MessageDigest.getInstance("MD5")
            val array = md.digest(md5.toByteArray(charset("UTF-8")))
            val sb = StringBuffer()
            for (i in array.indices) {
                sb.append(Integer.toHexString(array[i] + 0xFF or 0x100).substring(1, 3))
            }
            return sb.toString()
        } catch (e: NoSuchAlgorithmException) {
        } catch (ex: Exception) {
        }
        return null
    }
}