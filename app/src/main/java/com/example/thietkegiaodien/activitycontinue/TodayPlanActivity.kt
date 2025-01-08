package com.example.thietkegiaodien.activitycontinue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.fragment.GeneralReportFragment
import com.example.thietkegiaodien.fragment.PlanTodayFragment
import com.example.thietkegiaodien.utils.SharedPreferenceManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TodayPlanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_plan)
        val rootLayout: LinearLayout = findViewById(R.id.main)
        val sharedPrefs = SharedPreferenceManager(this)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val clTodayPlan: ConstraintLayout = findViewById(R.id.tab_layout_today_plan)
        val clGeneralReport: ConstraintLayout = findViewById(R.id.tab_layout_general_report)
        val tvTodayPlan: TextView = findViewById(R.id.tv_title_today_plan)
        val tvGeneralReport: TextView = findViewById(R.id.tv_title_general_report)
        tvTodayPlan.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
        tvGeneralReport.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))

        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
            clTodayPlan.setBackgroundResource(R.drawable.custom_tablayout_man_selector)
            clGeneralReport.setBackgroundResource(R.drawable.custom_tablayout_man_selector)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
            clTodayPlan.setBackgroundResource(R.drawable.custom_tablayout_woman_selector)
            clGeneralReport.setBackgroundResource(R.drawable.custom_tablayout_woman_selector)
        }
        clTodayPlan.isSelected = true
        clGeneralReport.isSelected = false

        clTodayPlan.setOnClickListener {
            clTodayPlan.isSelected = true
            clGeneralReport.isSelected = false
            tvTodayPlan.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
            tvGeneralReport.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))
            viewPager.setCurrentItem(0, true)
        }
        clGeneralReport.setOnClickListener {
            clTodayPlan.isSelected = false
            clGeneralReport.isSelected = true
            tvTodayPlan.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))
            tvGeneralReport.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
            viewPager.setCurrentItem(1, true)
        }

        val fragments = listOf(
            PlanTodayFragment(),
            GeneralReportFragment()
        )

        val titles = listOf(
            "Plan for today",
            "General report"
        )

        val adapter = ViewPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    clTodayPlan.isSelected = true
                    clGeneralReport.isSelected = false
                    tvTodayPlan.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
                    tvGeneralReport.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))
                } else {
                    clTodayPlan.isSelected = false
                    clGeneralReport.isSelected = true
                    tvTodayPlan.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))
                    tvGeneralReport.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
                }

            }
        })

    }

    class ViewPagerAdapter(
        fragmentActivity: FragmentActivity,
        private val fragments: List<Fragment>
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }

}