package com.example.thietkegiaodien

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val btStartProgram: Button = findViewById(R.id.bt_start_the_program)
        val sharedPrefs = SharedPreferenceManager(this)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            btStartProgram.setBackgroundResource(R.drawable.button_man)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            btStartProgram.setBackgroundResource(R.drawable.button_woman)
        }

    }
}