package com.example.thietkegiaodien

import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChoosingGenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_gender)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom)
        val zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)

        val cardView = findViewById<CardView>(R.id.cardView3)
        cardView.setOnClickListener {
            cardView.startAnimation(slideIn)
        }
        cardView.setOnLongClickListener {
            cardView.startAnimation(zoomIn)
            false
        }

        val manButton: Button = findViewById(R.id.bt_man)
        val womanButton: Button = findViewById(R.id.bt_woman)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val fabTurnLeft: FloatingActionButton = findViewById(R.id.fab_turn_left)
        val fabTurnRight: FloatingActionButton = findViewById(R.id.fab_turn_right)

        manButton.isSelected = true
        womanButton.isSelected = false

        fabTurnLeft.setBackgroundResource(R.drawable.button_man)
        fabTurnRight.setBackgroundResource(R.drawable.button_man)

        manButton.setOnClickListener {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            manButton.isSelected = true
            womanButton.isSelected = false
            manButton.setTextColor(Color.WHITE)
            womanButton.setTextColor(Color.BLACK)
        }

        womanButton.setOnClickListener {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            womanButton.isSelected = true
            manButton.isSelected = false
            womanButton.setTextColor(Color.WHITE)
            manButton.setTextColor(Color.BLACK)
        }

    }
}