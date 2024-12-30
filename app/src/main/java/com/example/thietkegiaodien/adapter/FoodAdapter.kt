package com.example.thietkegiaodien.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.model.FoodModel

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.thietkegiaodien.R

class FoodAdapter(private val foodList: List<FoodModel>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // ViewHolder class to hold each item's view
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFoodName: TextView = itemView.findViewById(R.id.tvFoodName)
        val tvFoodAmount: TextView = itemView.findViewById(R.id.tvFoodAmount)
        val tvFoodCalories: TextView = itemView.findViewById(R.id.tvFoodCalories)
    }

    // Inflate the item layout and create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    // Bind data to the item views
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.tvFoodName.text = food.name
        holder.tvFoodAmount.text = food.amount
        holder.tvFoodCalories.text = "Calories: ${food.numberOfCalories}"
    }

    // Return the total number of items
    override fun getItemCount(): Int = foodList.size
}
