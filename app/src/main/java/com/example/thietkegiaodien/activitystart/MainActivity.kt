package com.example.thietkegiaodien.activitystart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.activitycontinue.TodayPlanActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvStart: ConstraintLayout = findViewById<ConstraintLayout>(R.id.cv_start_a_new_program)
        val cvContinue: ConstraintLayout = findViewById<ConstraintLayout>(R.id.cv_continue_the_program)
        cvStart.setOnClickListener {
            Intent(this@MainActivity
                , ChoosingGenderActivity::class.java).apply {
                startActivity(this)
            }
        }
        cvContinue.setOnClickListener {
            Intent(this@MainActivity
                , TodayPlanActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}