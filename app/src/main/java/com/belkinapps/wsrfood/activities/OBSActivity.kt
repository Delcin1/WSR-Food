package com.belkinapps.wsrfood.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.belkinapps.wsrfood.ViewPagerAdapter
import com.belkinapps.wsrfood.databinding.OnBoardingScreenBinding
import com.google.android.material.tabs.TabLayoutMediator

class OBSActivity : AppCompatActivity() {

    private lateinit var binding: OnBoardingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OnBoardingScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val view_pager2: ViewPager2 = binding.pager
        val tabLayout = binding.tabLayout
        view_pager2.adapter = ViewPagerAdapter()
        TabLayoutMediator(tabLayout, view_pager2) { tab, position ->
            //Some implementation...
        }.attach()
    }
}