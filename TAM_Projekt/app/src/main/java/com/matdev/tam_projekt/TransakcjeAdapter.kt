package com.matdev.tam_projekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TransakcjeAdapter(private val transakcje: ArrayList<Transakcje>) :
    RecyclerView.Adapter<TransakcjeAdapter.TransakcjeHolder>(){

    class TransakcjeHolder (view: View) : RecyclerView.ViewHolder(view) {
        val etykieta : TextView = view.findViewById(R.id.etykieta)
        val ilość : TextView = view.findViewById(R.id.ilość)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransakcjeAdapter.TransakcjeHolder {
        val view : View! =  LayoutInflater.from(parent.context).inflate(R.layout.transakcje_layout, parent, attachToRoot: false)
        return  TransakcjeHolder(view)
    }

    override fun OnBindViewHolder(holder: TransakcjeHolder, position: Int){

    }
}