package com.example.thietkegiaodien.activitycontinue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.utils.SharedPreferenceManager

class ChooseWeightActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_weight2)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val sharedPrefs = SharedPreferenceManager(this)
        val fabTurnLeft: ImageButton = findViewById(R.id.fab_turn_left)
        val fabHome: ImageButton = findViewById(R.id.fab_home)
        val fabTurnRight: ImageButton = findViewById(R.id.fab_turn_right)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_man)
            fabHome.setBackgroundResource(R.drawable.button_turn_man)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_man)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_woman)
            fabHome.setBackgroundResource(R.drawable.button_turn_woman)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_woman)
        }
        fabTurnRight.setOnClickListener {
            Intent(this@ChooseWeightActivity2, AddDishSuccesfullyActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}