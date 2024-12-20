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

class ChoosingWeightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_weight)
        val rootLayout: ConstraintLayout = findViewById(R.id.main)
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

        val etWeightNow: EditText = findViewById(R.id.et_weight_now)
        val etDesiredWeight: EditText = findViewById(R.id.et_desired_weight)
        val etDuration: EditText = findViewById(R.id.et_duration)

        fabTurnRight.setOnClickListener {
            val weightNow = Integer.parseInt(if (!etWeightNow.text.toString().equals("")) etWeightNow.text.toString() else "0")
            val desiredWeight = Integer.parseInt(if (!etDesiredWeight.text.toString().equals("")) etDesiredWeight.text.toString() else "0");
            val duration = Integer.parseInt(if (!etDuration.text.toString().equals("")) etDuration.text.toString() else "0")
            if (desiredWeight > 150 || desiredWeight < 30) {
                val myCustomDialog: MyCustomDialog =
                    MyCustomDialog("Sorry, the specified weight \n" +
                            "may harm your health. \n" +
                            "Please specify another desired weight.",this)
                myCustomDialog.show()

            } else if (duration < 1) {
                val myCustomDialog: MyCustomDialog =
                    MyCustomDialog("Sorry, but we cannot achieve the " +
                            "\n result that quickly. Please specify " +
                            "\n a different program duration.",this)
                myCustomDialog.show()

            } else {
                Intent(this@ChoosingWeightActivity,
                    SuccessActivity::class.java).apply{
                    startActivity(this)
                }
            }

        }
    }
}