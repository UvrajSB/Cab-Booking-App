package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuvraj.cab_booking_app.DataClasses.Booking
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.adapters.MyBookingsAdapter
import com.yuvraj.cab_booking_app.databinding.FragmentMyBookingsBinding


class MyBookingsFragment : Fragment() {
    lateinit var binding: FragmentMyBookingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_bookings, container, false)

        var MyBookings = mutableListOf<Booking>(
            Booking("Hyd to Goa","12PM","10/12/2056"),
            Booking("Hyd to Goa","12PM","10/12/2056"),
            Booking("Hyd to Goa","12PM","10/12/2056"),
            Booking("Hyd to Goa","12PM","10/12/2056"),
            Booking("Hyd to Goa","12PM","10/12/2056"),
            Booking("Hyd to Goa","12PM","10/12/2056"),
            Booking("Hyd to Goa","12PM","10/12/2056")
        )
        val adapter = MyBookingsAdapter(MyBookings)
        binding.bookingsRvMbf.adapter = adapter
        binding.bookingsRvMbf.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

}