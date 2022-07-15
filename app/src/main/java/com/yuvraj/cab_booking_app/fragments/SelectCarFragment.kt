package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuvraj.cab_booking_app.DataClasses.Car
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.adapters.SelectCarRVAdapter
import com.yuvraj.cab_booking_app.databinding.FragmentSelectCarBinding

class SelectCarFragment : Fragment() {
    lateinit var binding: FragmentSelectCarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_select_car, container, false)

        var CarsList = mutableListOf<Car>(
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus),
            Car("Swift Dzire", "UP 75 Y 1254", "Rs 500 / day", R.drawable.urus)
        )

        val adapter = SelectCarRVAdapter(CarsList)
        binding.rvScf.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}