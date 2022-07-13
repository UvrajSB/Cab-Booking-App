package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.databinding.FragmentSelectCarBinding

class SelectCarFragment : Fragment() {
    lateinit var binding: FragmentSelectCarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_select_car, container, false)
        return binding.root
    }
}