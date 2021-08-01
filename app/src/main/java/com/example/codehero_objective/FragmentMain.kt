package com.example.codehero_objective

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codehero_objective.databinding.FragmentBuscaMarvelBinding
import com.example.codehero_objective.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout

class FragmentMain : Fragment() {

    private var binding:FragmentMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tab = binding?.tabLayout?.getTabAt(0)
        tab?.select()

        val fragmentList = listOf(BuscaMarvel(),BuscaMarvel(),BuscaMarvel())
        val fragmentTitleList = listOf("Nome", "Series", "Eventos")

        activity?.let{
            val viewPagerAdapter = TabAdapter(fragmentManager = it.supportFragmentManager,fragmentList = fragmentList, fragmentTitleList = fragmentTitleList)
            binding?.tabAdapterContainer?.adapter = viewPagerAdapter
            binding?.tabLayout?.setupWithViewPager(binding?.tabAdapterContainer)
        }
}

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}