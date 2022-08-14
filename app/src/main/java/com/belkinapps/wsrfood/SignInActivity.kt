package com.belkinapps.wsrfood

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.belkinapps.wsrfood.data.remote.FoodApi
import com.belkinapps.wsrfood.data.requests.LoginRequest
import com.belkinapps.wsrfood.databinding.ActivitySignInBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val compositeDisposable = CompositeDisposable()
    lateinit var foodApi: FoodApi
    var pref: SharedPreferences? = null
    var isLogged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val loginBtn = binding.loginBtn
        loginBtn.setOnClickListener {
            foodApi = (application as? App)?.foodApi!!
            compositeDisposable.add(foodApi.sendLoginRequest(
                LoginRequest(
                    email = binding.siEmailField.text.toString(),
                    password = binding.siPasswordField.text.toString()
            )
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isLogged = true
                    SaveState(isLogged)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }, {
                    Toast.makeText(applicationContext, "Неверный e-mail или пароль", Toast.LENGTH_SHORT).show()
                }))
        }


    }

    fun SaveState(state: Boolean) {
        val editor = pref?.edit()
        editor?.putBoolean("isLogged", state)
        editor?.apply()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}