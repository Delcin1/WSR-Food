package com.belkinapps.wsrfood.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belkinapps.wsrfood.R
import com.belkinapps.wsrfood.adapters.OrderRecyclerAdapter
import com.belkinapps.wsrfood.data.requests.DishesOrder
import com.belkinapps.wsrfood.data.responses.Item
import com.belkinapps.wsrfood.databinding.ActivityOrderBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adress = pref?.getString("adress", "")
        val adressField = binding.orderAdress
        adressField.text = adress

        var orderList: MutableList<DishesOrder> = pref?.getList<DishesOrder>("DishesOrder") as MutableList<DishesOrder>
        var dishesList: MutableList<Item> = pref?.getList<Item>("menu") as MutableList<Item>
        if (!orderList.isEmpty()) {
            val noOrdersCart = binding.noOrdersCart
            val noOrdersText = binding.noOrdersText
            val orderRecycler = binding.orderRecycler
            val totalPrice = binding.materialCardView3
            val makeOrder = binding.makeOrderBtn
            noOrdersCart.visibility = View.GONE
            noOrdersText.visibility = View.GONE
            orderRecycler.visibility = View.VISIBLE
            totalPrice.visibility = View.VISIBLE
            makeOrder.visibility = View.VISIBLE
            orderRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            var orderPrice = 0
            val updOrderPrice = {orderList = pref?.getList<DishesOrder>("DishesOrder") as MutableList<DishesOrder>;
                for (item: DishesOrder in orderList){
                    for (i:Item in dishesList){
                        if (i.dishId == item.dishId){
                            orderPrice += item.count * i.price.toInt()
                        }
                    }
                }; totalPrice}
            orderRecycler.adapter = OrderRecyclerAdapter(dishesList, pref)
        }

        val homeBtn = binding.orderHome
        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    inline fun <reified T> SharedPreferences.getList(spListKey: String): MutableList<T> {
        val listJson = getString(spListKey, "")
        if (!listJson.isNullOrBlank()) {
            val type = object : TypeToken<MutableList<T>>() {}.type
            return Gson().fromJson(listJson, type)
        }
        return mutableListOf()
    }
}