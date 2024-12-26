package com.example.thietkegiaodien.activitystart

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.thietkegiaodien.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_DELAY = 1000L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val intent: Intent = Intent(
                this@SplashActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_DELAY)
    }
}