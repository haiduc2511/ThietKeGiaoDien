package com.example.thietkegiaodien.activitycontinue

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.adapter.Food2Adapter
import com.example.thietkegiaodien.adapter.FoodAdapter
import com.example.thietkegiaodien.model.Food2Model
import com.example.thietkegiaodien.model.FoodModel
import com.example.thietkegiaodien.utils.SharedPreferenceManager

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val category: String? = intent.getStringExtra("Category")
        val tvCategory: TextView = findViewById(R.id.tv_category)
        tvCategory.setText(category)

        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val sharedPrefs = SharedPreferenceManager(this)
        val fabTurnLeft: ImageButton = findViewById(R.id.fab_turn_left)
        val fabTurnRight: ImageButton = findViewById(R.id.fab_turn_right)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_man)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_man)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_woman)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_woman)
        }

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

        val vlNoItems: ConstraintLayout = findViewById(R.id.cl_no_items)

        val etSearch: EditText = findViewById(R.id.searchEditText)
        etSearch.addTextChangedListener {
            if (!it.toString().equals("")) {
                recyclerView.visibility = View.GONE
                vlNoItems.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                vlNoItems.visibility = View.GONE
            }
        }
    }
}