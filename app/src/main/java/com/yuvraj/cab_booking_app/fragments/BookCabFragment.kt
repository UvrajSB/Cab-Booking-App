package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.databinding.FragmentBookCabBinding

class BookCabFragment : Fragment() {
    lateinit var binding: FragmentBookCabBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_book_cab, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myBookingsBtnBcf.setOnClickListener{
            findNavController().navigate(R.id.action_bookCabFragment_to_myBookingsFragment)
        }
        binding.bookNowBtnBcf.setOnClickListener {
            findNavController().navigate(R.id.action_bookCabFragment_to_selectLocationFragment)
        }
    }
}