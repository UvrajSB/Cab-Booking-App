package com.yuvraj.cab_booking_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yuvraj.cab_booking_app.DataClasses.Booking
import com.yuvraj.cab_booking_app.R

class MyBookingsAdapter(var bookings : List<Booking>) : RecyclerView.Adapter<MyBookingsAdapter.MyBookingsViewHolder>() {

    inner class MyBookingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_bookings_rv_item,parent,false)
        return MyBookingsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyBookingsViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.destination_tv_mbi).text = bookings[position].destinations
            findViewById<TextView>(R.id.time_tv_mbi).text = bookings[position].time
            findViewById<TextView>(R.id.date_tv_mbi).text = bookings[position].date
        }
    }

    override fun getItemCount(): Int {
        return bookings.size
    }

}