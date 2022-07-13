package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_category, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextCvCf.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_selectCarFragment)
        }
    }

}