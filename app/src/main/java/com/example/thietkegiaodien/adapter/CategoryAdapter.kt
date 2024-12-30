package com.example.thietkegiaodien.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.R

class CategoryAdapter(
    private val categories: List<Pair<String, Int>> // Pair of category name and drawable resource
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.categoryIcon)
        val label: TextView = itemView.findViewById(R.id.categoryLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val (label, iconRes) = categories[position]
        holder.label.text = label
        holder.icon.setImageResource(iconRes)
    }

    override fun getItemCount(): Int = categories.size
}
