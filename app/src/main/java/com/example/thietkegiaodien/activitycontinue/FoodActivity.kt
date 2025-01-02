package com.example.thietkegiaodien.activitycontinue

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.adapter.Food2Adapter
import com.example.thietkegiaodien.adapter.FoodAdapter
import com.example.thietkegiaodien.model.Food2Model
import com.example.thietkegiaodien.model.FoodModel

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val category: String? = intent.getStringExtra("Category")
        val tvCategory: TextView = findViewById(R.id.tv_category)
        tvCategory.setText(category)

        val foodList = listOf(
            Food2Model("Banana", 95),
            Food2Model("Apple", 47),
            Food2Model("Grapes", 70),
            Food2Model("Orange", 36),
            Food2Model("Mandarin", 60),
            Food2Model("Apricot", 44),
            Food2Model("Mango", 67)
        )

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Food2Adapter(foodList)


    }
}