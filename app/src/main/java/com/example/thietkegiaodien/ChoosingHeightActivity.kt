package com.example.thietkegiaodien

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChoosingHeightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_height)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val etChooseHeight: EditText = findViewById(R.id.et_choose_height)
        val fabTurnLeft: ImageButton = findViewById(R.id.fab_turn_left)
        val fabTurnRight: ImageButton = findViewById(R.id.fab_turn_right)
        val sharedPrefs = SharedPreferenceManager(this)
        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_man)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_man)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            fabTurnLeft.setBackgroundResource(R.drawable.button_turn_woman)
            fabTurnRight.setBackgroundResource(R.drawable.button_turn_woman)
        }

        fabTurnRight.setOnClickListener {
            var height = 0
            if (!etChooseHeight.text.toString().equals("")) {
                height = Integer.parseInt(etChooseHeight.text.toString())
            }
            if (height < 100 || height > 250) {
                val myCustomDialog: MyCustomDialog =
                    MyCustomDialog("Please specify a value\n between 100 cm and 250 cm.",this)
                myCustomDialog.show()
            } else {
                Intent(this@ChoosingHeightActivity,
                    ChoosingWeightActivity::class.java).apply{
                    startActivity(this)
                }
            }
        }
        fabTurnLeft.setOnClickListener {
            onBackPressedDispatcher.onBackPressed();
        }

    }
}