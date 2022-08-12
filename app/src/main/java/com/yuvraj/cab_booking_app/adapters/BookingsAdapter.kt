package com.yuvraj.cab_booking_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yuvraj.cab_booking_app.DataClasses.Booking
import com.yuvraj.cab_booking_app.DataClasses.Car
import com.yuvraj.cab_booking_app.R

class BookingsAdapter(var bookings: ArrayList<Booking>):
    RecyclerView.Adapter<BookingsAdapter.BookingsViewHolder>() {

    inner class BookingsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_bookings_rv_item,parent,false)
        return BookingsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingsViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.date_tv_mbf).text = bookings[position].cabDate
        holder.itemView.findViewById<TextView>(R.id.time_tv_mbf).text = bookings[position].cabTime
        holder.itemView.findViewById<TextView>(R.id.carNum_tv_mbf).text = bookings[position].carNum
        holder.itemView.findViewById<TextView>(R.id.destinations_tv_mbf).text = bookings[position].aLoc + " to " +  bookings[position].dLoc
    }

    override fun getItemCount(): Int {
        return bookings.size
    }
}
