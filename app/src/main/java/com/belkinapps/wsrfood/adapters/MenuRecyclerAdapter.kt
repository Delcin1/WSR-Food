package com.belkinapps.wsrfood.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belkinapps.wsrfood.R
import com.belkinapps.wsrfood.data.responses.Item
import com.squareup.picasso.Picasso

class MenuRecyclerAdapter(var items: MutableList<Item>) : RecyclerView.Adapter<MenuRecyclerVH>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(filteredList: MutableList<Item>){
        this.items = filteredList
        notifyDataSetChanged()
        println(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuRecyclerVH =
        MenuRecyclerVH(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MenuRecyclerVH, position: Int) {
        println("Сработало")
        holder.nameDish.text = items[position].nameDish
        holder.price.text = "N${items[position].price}"
        Picasso.get()
            .load("https://food.madskill.ru/up/images/${items[position].icon}")
            .into(holder.dishIcon)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class MenuRecyclerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val nameDish: TextView = itemView.findViewById(R.id.nameDish)
    val price: TextView = itemView.findViewById(R.id.price)
    val dishIcon: ImageView = itemView.findViewById(R.id.dishIcon)

}