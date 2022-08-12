package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.yuvraj.cab_booking_app.DataClasses.Booking
import com.yuvraj.cab_booking_app.DataClasses.Car
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.adapters.BookingsAdapter
import com.yuvraj.cab_booking_app.adapters.SelectCarRVAdapter
import com.yuvraj.cab_booking_app.databinding.FragmentMyBookingsBinding
import java.security.Timestamp
import java.util.*
import kotlin.collections.ArrayList


class MyBookingsFragment : Fragment() {
    lateinit var binding: FragmentMyBookingsBinding
    lateinit var _adapter: BookingsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_bookings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val bookingList = arrayListOf<Booking>(
//            Booking("UP 75 1232", "Etawah", "Agra", "7PM", "12/01/2023"),
//            Booking("UP 75 1232", "Etawah", "Agra", "7PM", "12/01/2023"),
//            Booking("UP 75 1232", "Etawah", "Agra", "7PM", "12/01/2023"),
//            Booking("UP 75 1232", "Etawah", "Agra", "7PM", "12/01/2023"),
//            Booking("UP 75 1232", "Etawah", "Agra", "7PM", "12/01/2023"),
//            Booking("UP 75 1232", "Etawah", "Agra", "7PM", "12/01/2023")
//        )
        var bookingsList = ArrayList<Booking>()
        val db = Firebase.firestore
        db.collection(FirebaseAuth.getInstance().currentUser!!.uid).get()
            .addOnSuccessListener { Bookings ->
                var newBooking: Booking
                bookingsList.clear()
                for (booking in Bookings){
                    newBooking = Booking(booking.getString("CabNum"),booking.getString("ALoc"),booking.getString("DLoc"),booking.getString("cabTime"),booking.getString("cabDate"))
                    for (i in 1..3) {
                        bookingsList.add(newBooking)
                    }
                    val rv = view.findViewById<RecyclerView>(R.id.rv_mbf)
                    _adapter = BookingsAdapter(bookingsList)
                    rv.adapter = _adapter
                    rv.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }



    }


