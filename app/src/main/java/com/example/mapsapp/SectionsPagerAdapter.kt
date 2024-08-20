package com.example.mapsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mapsapp.data.Fragment_2019
import com.example.mapsapp.data.Fragment_2020
import com.example.mapsapp.data.Fragment_2023

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = Fragment_2023()
            1 -> fragment = Fragment_2020()
            2 -> fragment = Fragment_2019()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}