package com.example.thietkegiaodien.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.thietkegiaodien.R
import com.example.thietkegiaodien.utils.SharedPreferenceManager

/**
 * A simple [Fragment] subclass.
 * Use the [PlanTodayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PlanTodayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_plan_today, container, false)
        val spinner = view.findViewById<AppCompatSpinner>(R.id.appCompatSpinner)

        // Array of options
        val options = arrayOf("< daily norm", "250 kcal to the daily norm.", "> daily norm")

        // Create ArrayAdapter
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Set Spinner listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Change Spinner background color based on selected item
                when (position) {
                    0 -> spinner.setBackgroundResource(R.drawable.spinner_daily_norm_green_gradient)
                    1 -> spinner.setBackgroundResource(R.drawable.spinner_daily_norm_yellow_gradient)
                    2 -> spinner.setBackgroundResource(R.drawable.spinner_daily_norm_red_gradient)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No action needed here
            }
        }

        val btHistoryOfNutrition = view.findViewById<ConstraintLayout>(R.id.cardView6)
        val sharedPrefs = SharedPreferenceManager(requireContext())
        if (sharedPrefs.getString("gender").equals("man")) {
            btHistoryOfNutrition.setBackgroundResource(R.drawable.button_man)
        } else {
            btHistoryOfNutrition.setBackgroundResource(R.drawable.button_woman_2)
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlanTodayFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlanTodayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}