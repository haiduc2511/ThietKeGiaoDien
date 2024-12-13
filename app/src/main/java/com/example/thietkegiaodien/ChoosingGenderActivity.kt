package com.example.thietkegiaodien

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChoosingGenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_gender)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom)
        val zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)

        val cardView = findViewById<CardView>(R.id.cardView3)
        cardView.setOnClickListener {
            cardView.startAnimation(fadeIn)
        }
        cardView.setOnLongClickListener {
            cardView.startAnimation(slideIn)
            false
        }
    }
}