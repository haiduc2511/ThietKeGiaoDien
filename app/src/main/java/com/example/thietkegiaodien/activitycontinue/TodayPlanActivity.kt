package com.example.thietkegiaodien.activitycontinue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
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
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        if (sharedPrefs.getString("gender").equals("man")) {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_man_background)
//            tabLayout.setBackgroundResource(R.drawable.custom_tablayout_man_selector)
        } else {
            rootLayout.setBackgroundResource(R.drawable.choose_gender_woman_background)
//            tabLayout.setBackgroundResource(R.drawable.custom_tablayout_woman_selector)
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

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.customView = createCustomTab(titles[position], position)

        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                var customTabLayout = tab.customView!!.findViewById<View>(R.id.main_custom_tab_layout)
                customTabLayout.isSelected = true
                tab.customView!!.findViewById<TextView>(R.id.tabTitle).apply {
                    this.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
                    this.text = titles[tab.position]
                }

                when (tab.position) {
                    0 -> {
                        Toast.makeText(this@TodayPlanActivity, "Plan for today clicked!", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        Toast.makeText(this@TodayPlanActivity, "General report clicked!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                var customTabLayout = tab.customView!!.findViewById<View>(R.id.main_custom_tab_layout)
                customTabLayout.isSelected = false
                tab.customView!!.findViewById<TextView>(R.id.tabTitle).apply {
                    this.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle tab re-clicked
                Toast.makeText(this@TodayPlanActivity, "Tab re-clicked: ${tab.text}", Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun createCustomTab(title: String, position: Int): View {
        val tabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        if (SharedPreferenceManager(this).getString("gender").equals("man")) {
            tabView.setBackgroundResource(R.drawable.custom_tablayout_man_selector)
        } else {
            tabView.setBackgroundResource(R.drawable.custom_tablayout_woman_selector)
        }
        when (position) {
            0 -> {
                tabView.findViewById<TextView>(R.id.tabTitle).apply {
                    this.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.white))
                    this.text = title
                }
            }
            1 -> {
                tabView.findViewById<TextView>(R.id.tabTitle).apply {
                    this.setTextColor(ContextCompat.getColor(this@TodayPlanActivity, R.color.black))
                    this.text = title
                }
            }
        }

        return tabView
    }

    class ViewPagerAdapter(
        fragmentActivity: FragmentActivity,
        private val fragments: List<Fragment>
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }

}