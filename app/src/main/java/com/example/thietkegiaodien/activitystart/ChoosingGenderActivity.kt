package com.example.thietkegiaodien.activitystart

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.utils.SharedPreferenceManager

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
        val fabTurnLeft: ImageButton = findViewById(R.id.fab_turn_left)
        val fabTurnRight: ImageButton = findViewById(R.id.fab_turn_right)

        val sharedPrefs = SharedPreferenceManager(this)

        manButton.isSelected = true
        manButton.setTextColor(Color.WHITE)
        womanButton.isSelected = false
        sharedPrefs.setString("gender", "man")


        manButton.setOnClickListener {
            sharedPrefs.setString("gender", "man")

            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            manButton.isSelected = true
            womanButton.isSelected = false
            manButton.setTextColor(Color.WHITE)
            womanButton.setTextColor(Color.BLACK)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_man)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_man)
        }

        womanButton.setOnClickListener {
            sharedPrefs.setString("gender", "woman")

            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            womanButton.isSelected = true
            manButton.isSelected = false
            womanButton.setTextColor(Color.WHITE)
            manButton.setTextColor(Color.BLACK)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_woman)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_woman)

        }

        fabTurnRight.setOnClickListener {
            Intent(this@ChoosingGenderActivity, ChoosingHeightActivity::class.java).apply{
                startActivity(this)
            }
        }
        fabTurnLeft.setOnClickListener {
            onBackPressedDispatcher.onBackPressed();
        }

    }
}