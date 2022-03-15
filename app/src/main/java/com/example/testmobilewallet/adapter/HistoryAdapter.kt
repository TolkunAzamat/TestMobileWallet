package com.example.testmobilewallet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testmobilewallet.DataBase.entities.Pay
import com.example.testmobilewallet.DataBase.entities.Services
import com.example.testmobilewallet.R

class HistoryAdapter(private val array: Array<Pay>, val context: FragmentActivity):RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val sum=view.findViewById<TextView>(R.id.sum_service)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item=array[position]
        holder.sum.text=item.summa.toString()

    }

    override fun getItemCount(): Int {
        return array.size
    }
}