package com.belkinapps.wsrfood.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.belkinapps.wsrfood.R
import com.belkinapps.wsrfood.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)


    }
}