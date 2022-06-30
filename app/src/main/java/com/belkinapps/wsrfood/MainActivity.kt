package com.belkinapps.wsrfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var isLogged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isLogged) {
            setContentView(R.layout.activity_main)
        } else {
            setContentView(R.layout.on_boarding_screen)
            val view_pager2: ViewPager2 = findViewById(R.id.pager)
            val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
            view_pager2.adapter = ViewPagerAdapter()
            TabLayoutMediator(tabLayout, view_pager2) { tab, position ->
                //Some implementation...
            }.attach()
        }

    }
}