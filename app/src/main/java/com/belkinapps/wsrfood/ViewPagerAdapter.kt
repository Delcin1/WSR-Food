package com.belkinapps.wsrfood

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.on_boarding_screen_1_2, parent, false))

    override fun getItemCount(): Int = 2


    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {

        if(position == 0){
            holder.imageView5.setImageResource(R.drawable.ic_ililustration_1)
            holder.textView2.setText(R.string.delivery)
            holder.textView3.setText(R.string.work)
        }
        if(position == 1) {
            holder.imageView.setImageResource(R.drawable.ic_illustration)
            holder.imageView6.setImageResource(R.drawable.ic_rectangle_473)
            holder.textView4.setText(R.string.welcome)
            holder.textView5.setText(R.string.app_name)
            holder.button2.scaleX = 1F
            holder.button3.scaleX = 1F
            holder.button2.setText(R.string.sign_in)
            holder.button3.setText(R.string.sign_up)

        }
    }

}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView5: ImageView = itemView.findViewById(R.id.imageView5)
    val textView2: TextView = itemView.findViewById(R.id.textView2)
    val textView3: TextView = itemView.findViewById(R.id.textView3)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val imageView6: ImageView = itemView.findViewById(R.id.imageView6)
    val textView4: TextView = itemView.findViewById(R.id.textView4)
    val textView5: TextView = itemView.findViewById(R.id.textView5)
    val button2: Button = itemView.findViewById(R.id.button2)
    val button3: Button = itemView.findViewById(R.id.button3)
}