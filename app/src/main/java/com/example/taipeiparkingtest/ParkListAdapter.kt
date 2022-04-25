package com.example.taipeiparkingtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class ParkListAdapter(var parkList: DataModel): RecyclerView.Adapter<ParkListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parking_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkListAdapter.ViewHolder, position: Int) {

        val parkObject = ((parkList.data)!!.park!!)[position]
        holder.nameTextView.text = parkObject.name
        holder.telTextView.text = parkObject.tel
        holder.addressTextView.text = parkObject.address
    }


    override fun getItemCount(): Int {
        if ((parkList.data)!!.park!!.size > 0) {
            return (parkList.data)!!.park!!.size
        }
        return 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<AppCompatTextView>(R.id.nameTextView)
        val telTextView = itemView.findViewById<AppCompatTextView>(R.id.telTextView)
        val addressTextView = itemView.findViewById<AppCompatTextView>(R.id.addressTextView)
    }
}