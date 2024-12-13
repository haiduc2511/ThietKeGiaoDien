package com.example.thietkegiaodien

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvStart: ConstraintLayout = findViewById<ConstraintLayout>(R.id.cv_start_a_new_program)
        cvStart.setOnClickListener {
            Intent(this@MainActivity
                , ChoosingGenderActivity::class.java).apply {
                startActivity(this)
            }
        }


    }
}