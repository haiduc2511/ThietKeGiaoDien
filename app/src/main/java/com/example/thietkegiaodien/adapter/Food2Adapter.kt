package com.example.thietkegiaodien.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.model.FoodModel

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.customview.MyCustomDialog
import com.example.thietkegiaodien.customview.MyCustomDialog2
import com.example.thietkegiaodien.model.Food2Model

class Food2Adapter(private val food2List: List<Food2Model>) :
    RecyclerView.Adapter<Food2Adapter.FoodViewHolder>() {

    // ViewHolder class to hold each item's view
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFoodName: TextView = itemView.findViewById(R.id.tvFoodName)
        val tvFoodCalories: TextView = itemView.findViewById(R.id.tvFoodCalories)
        val ivAdd: ImageView = itemView.findViewById(R.id.imageView3)
    }

    // Inflate the item layout and create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food_2, parent, false)
        return FoodViewHolder(view)
    }

    // Bind data to the item views
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = food2List[position]
        holder.tvFoodName.text = food.name
        holder.tvFoodCalories.text = "${food.numberOfCaloriesPer100r} Kcal"
        holder.ivAdd.setOnClickListener {
            MyCustomDialog2(holder.itemView.context).show()
        }
    }

    // Return the total number of items
    override fun getItemCount(): Int = food2List.size
}
