package com.example.thietkegiaodien.activitycontinue

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.activitystart.MainActivity
import com.example.thietkegiaodien.activitystart.SplashActivity
import com.example.thietkegiaodien.utils.SharedPreferenceManager

class CompletedProgramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed_program)

        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val btMainMenu: TextView = findViewById(R.id.bt_main_menu)
        val btExit: TextView = findViewById(R.id.bt_exit)
        val sharedPrefs = SharedPreferenceManager(this)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            btMainMenu.setBackgroundResource(R.drawable.button_man)
            btExit.setBackgroundResource(R.drawable.button_man)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            btMainMenu.setBackgroundResource(R.drawable.button_woman_2)
            btExit.setBackgroundResource(R.drawable.button_woman_2)
        }

        btMainMenu.setOnClickListener {
            Intent(this@CompletedProgramActivity,
                MainActivity::class.java).apply{
                startActivity(this)
                finish()
            }
        }
        btExit.setOnClickListener {
            Intent(this@CompletedProgramActivity,
                SplashActivity::class.java).apply{
                startActivity(this)
                finish()
            }

        }
    }
}