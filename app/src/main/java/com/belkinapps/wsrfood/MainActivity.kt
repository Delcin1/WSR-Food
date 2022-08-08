package com.belkinapps.wsrfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var isLogged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isLogged) {
            setContentView(R.layout.activity_main)
        } else {
            setContentView(R.layout.on_boarding_screen)
            val intent = Intent(this, OBSActivity::class.java)
            startActivity(intent)
        }

    }
}
