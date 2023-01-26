package com.utad.listacompra

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class FoodAdapter(private val foodList : ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.image.setImageResource(currentItem.image)
        holder.foodName.text = currentItem.food
        holder.foodPrice.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val image : ImageView = itemView.findViewById(R.id.imageView)
        val foodName : TextView = itemView.findViewById(R.id.txtFood)
        val foodPrice : TextView = itemView.findViewById(R.id.txtPrice)

    }

}