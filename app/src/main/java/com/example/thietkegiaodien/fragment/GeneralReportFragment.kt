package com.example.thietkegiaodien.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.thietkegiaodien.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GeneralReportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GeneralReportFragment : Fragment() {
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_general_report, container, false)
        val linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)

        // Danh sách dữ liệu (ví dụ: tiêu đề cho mỗi custom view)
        val titles = listOf("Completed days", "Days left", "Burned", "Current weight")

        // Inflate và thêm từng custom view vào LinearLayout
        for (title in titles) {
            val customView = inflater.inflate(R.layout.custom_view_general_report, linearLayout, false)

            // Cập nhật nội dung tùy chỉnh
            val textView = customView.findViewById<TextView>(R.id.tv_message) // ID trong custom_view_general_report
            textView.text = title

            linearLayout.addView(customView)
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
         * @return A new instance of fragment GeneralReportFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GeneralReportFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}