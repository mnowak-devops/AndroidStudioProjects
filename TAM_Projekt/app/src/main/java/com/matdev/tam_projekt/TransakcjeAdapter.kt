package com.matdev.tam_projekt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TransakcjeAdapter(private var transakcje: List<Transakcje>) :
    RecyclerView.Adapter<TransakcjeAdapter.TransakcjeHolder>() {

    class TransakcjeHolder(view: View) : RecyclerView.ViewHolder(view) {
        val etykieta : TextView = view.findViewById(R.id.etykieta)
        val ilość : TextView = view.findViewById(R.id.ilość)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransakcjeHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.transakcje_layout, parent,false)
        return TransakcjeHolder(view)
    }

    override fun onBindViewHolder(holder: TransakcjeHolder, position: Int) {
        val transakcja  = transakcje[position]
        val context = holder.ilość.context

        if (transakcja.ilość >= 0) {
            holder.ilość.text = "+ %.2f zł".format(transakcja.ilość)
            holder.ilość.setTextColor(ContextCompat.getColor(context, R.color.green))
        } else {
            holder.ilość.text = "- %.2f zł".format(Math.abs(transakcja.ilość))
            holder.ilość.setTextColor(ContextCompat.getColor(context, R.color.red))
        }
        holder.etykieta.text = transakcja.etykieta
    }

    override fun getItemCount(): Int {
        return transakcje.size
    }

    fun setData(transakcje: List<Transakcje>){
        this.transakcje = transakcje
        notifyDataSetChanged()
    }
}