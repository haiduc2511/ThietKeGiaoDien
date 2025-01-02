package com.example.thietkegiaodien.activitycontinue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thietkegiaodien.R
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thietkegiaodien.adapter.FoodAdapter
import com.example.thietkegiaodien.model.FoodModel
import com.example.thietkegiaodien.utils.SharedPreferenceManager

class TrackDietActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_diet)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val sharedPrefs = SharedPreferenceManager(this)
        val fabTurnLeft: ImageButton = findViewById(R.id.fab_turn_left)
        val fabTurnRight: ImageButton = findViewById(R.id.fab_turn_right)
        val cvAdd: ConstraintLayout = findViewById(R.id.cardView6)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_man)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_man)
            cvAdd.setBackgroundResource(R.drawable.button_man)

        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_woman)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_woman)
            cvAdd.setBackgroundResource(R.drawable.button_woman_2)
        }

        val foodList = listOf(
            FoodModel("Apple", "1 unit", 95),
            FoodModel("Banana", "1 unit", 105),
            FoodModel("Pizza", "1 slice", 285),
            FoodModel("Salad", "1 bowl", 150)
        )

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FoodAdapter(foodList)

        val btAdd = findViewById<ConstraintLayout>(R.id.cardView6)
        btAdd.setOnClickListener {
            Intent(this@TrackDietActivity, FoodCategoryActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}