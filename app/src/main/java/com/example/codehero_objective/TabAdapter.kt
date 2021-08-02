package com.example.codehero_objective

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(fragmentManager: FragmentManager,
                 private val fragmentList:List<Fragment>,
                 private val fragmentTitleList:List<String>): FragmentPagerAdapter(fragmentManager){

    override fun getCount() = fragmentList.size
    override fun getItem(position: Int) = fragmentList[position]
    override fun getPageTitle(position: Int) = fragmentTitleList[position]
}