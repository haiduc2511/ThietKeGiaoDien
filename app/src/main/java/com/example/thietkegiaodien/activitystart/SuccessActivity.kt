package com.example.thietkegiaodien.activitystart

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.activitycontinue.TodayPlanActivity
import com.example.thietkegiaodien.utils.SharedPreferenceManager

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val btStartProgram: TextView = findViewById(R.id.bt_start_the_program)
        val sharedPrefs = SharedPreferenceManager(this)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            btStartProgram.setBackgroundResource(R.drawable.button_turn_man)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            btStartProgram.setBackgroundResource(R.drawable.button_turn_woman)
        }

        btStartProgram.setOnClickListener {
            Intent(this@SuccessActivity,
                TodayPlanActivity::class.java).apply{
                startActivity(this)
            }

        }


    }
}