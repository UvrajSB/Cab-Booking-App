package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import coil.load
import coil.transform.CircleCropTransformation
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.databinding.FragmentMyBookingsBinding
import java.security.Timestamp
import java.util.*


class MyBookingsFragment : Fragment() {
    lateinit var binding: FragmentMyBookingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_bookings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bgIvMb.load("https://firebasestorage.googleapis.com/v0/b/yuvraj-cab-booking-app.appspot.com/o/Vehicles%2FHatchBack%2FHyundai_i20.jpg?alt=media&token=c4c1feb4-89f9-4fb2-9596-dd0a28b59e14") {
            crossfade(true)
            placeholder(R.drawable.place_holder)
            transformations(CircleCropTransformation())
        }

        binding.sendData.setOnClickListener {
            val db = Firebase.firestore

            val docData = hashMapOf(
                "TimeStamp" to  FieldValue.serverTimestamp()
            )

            db.collection("This is a demo collection").document("This is a demo doc").set(docData)
                .addOnSuccessListener {
                    Log.d("FirestoreTesting", "DocumentSnapshot successfully written!")
                }
                .addOnFailureListener {
                        e -> Log.w("FirestoreTesting", "Error writing document", e)
                }

        }

    }


}