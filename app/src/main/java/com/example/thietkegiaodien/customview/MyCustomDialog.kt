package com.example.thietkegiaodien.customview

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.example.thietkegiaodien.R

class MyCustomDialog(private val message: String, context: Context) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        setContentView(view)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setLayout(dpToPx(307), dpToPx(181))

        val tvMessage: TextView = view.findViewById(R.id.tv_message)
        tvMessage.setText(message)



        val btnClose: Button = view.findViewById(R.id.bt_ok)
        btnClose.setOnClickListener {
            dismiss() // Close the dialog when the button is clicked
        }
    }

    private fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics
        ).toInt()
    }

}
