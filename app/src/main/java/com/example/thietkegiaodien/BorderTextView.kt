package com.example.thietkegiaodien

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class BorderTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        val paint = paint
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 1f  // Border width
        paint.color = Color.BLACK  // Border color
        paint.textAlign = Paint.Align.CENTER  // Center text horizontally
        val textWidth = paint.measureText(text.toString())
        val x = width / 2f  // Center horizontally
        val y = (height / 2f) - (paint.ascent() + paint.descent()) / 2f  // Center vertically

        canvas.drawText(text.toString(), x, y, paint)

        paint.style = Paint.Style.FILL
        paint.strokeWidth = 0f
        paint.color = Color.WHITE  // Text color
        canvas.drawText(text.toString(), x, y, paint)

    }
}
