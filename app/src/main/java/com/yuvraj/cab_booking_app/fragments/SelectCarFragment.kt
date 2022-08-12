package com.yuvraj.cab_booking_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.yuvraj.cab_booking_app.DataClasses.Car
import com.yuvraj.cab_booking_app.R
import com.yuvraj.cab_booking_app.adapters.SelectCarRVAdapter
import com.yuvraj.cab_booking_app.databinding.FragmentSelectCarBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SelectCarFragment : Fragment() {
    lateinit var binding: FragmentSelectCarBinding
    var CarsList = ArrayList<Car>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_car, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Firebase.firestore
        db.collection("Vehicles").document("VehicleInfo").collection("SUV").get()
            .addOnSuccessListener { SUVs ->

                var newCar: Car
                CarsList.clear()
                for (SUV in SUVs){
                    Log.d("Show names of My SUVs", SUV.getString("CarName").toString())
                    newCar = Car(SUV.getString("CarName"),SUV.getString("CarNum"), SUV.getString("CarRate"), SUV.getString("CarImage"))
                    for (i in 1..5) {
                        CarsList.add(newCar)
                    }
                    val adapter = SelectCarRVAdapter(CarsList as ArrayList<Car>)
                    binding.rvScf.apply {
                        this.adapter = adapter
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("SelectCarList", "get failed with ", exception)
            }

    }
}