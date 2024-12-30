package com.example.thietkegiaodien.activitycontinue

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.adapter.CategoryAdapter
import com.example.thietkegiaodien.utils.SharedPreferenceManager

class FoodCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_category)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val sharedPrefs = SharedPreferenceManager(this)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
        }

        // Sample categories and icons
        val categories = listOf(
            "Dairy products" to R.drawable.ic_home,
            "Meat products" to R.drawable.ic_home,
            "Fish products" to R.drawable.ic_home,
            "Fruits" to R.drawable.ic_home,
            "Vegetables" to R.drawable.ic_home,
            "Bread products" to R.drawable.ic_home,
            "Drinks" to R.drawable.ic_home
        )

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = CategoryAdapter(categories)

    }
}