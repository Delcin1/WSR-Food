package com.belkinapps.wsrfood.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.belkinapps.wsrfood.R

class MainActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    var isLogged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        isLogged = pref?.getBoolean("isLogged", false)!!
        if (isLogged) {
            setContentView(R.layout.activity_main)
        } else {
            setContentView(R.layout.on_boarding_screen)
            val intent = Intent(this, OBSActivity::class.java)
            startActivity(intent)
        }

    }
}
