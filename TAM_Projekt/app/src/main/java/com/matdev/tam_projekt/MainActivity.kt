package com.matdev.tam_projekt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var transakcje: ArrayList<Transakcje>
    private lateinit var transakcjeAdapter: TransakcjeAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transakcje = arrayListOf(
            Transakcje(etykieta = "Budżet wekendowy", ilość = 200.00),
            Transakcje(etykieta = "Zakupy spożywcze", ilość = -132.23),
            Transakcje(etykieta = "Paliwo Orle", ilość = -85.56),
            Transakcje(etykieta = "Sniadanie Kavova", ilość = -56.00),
            Transakcje(etykieta = "Żabka zakpy", ilość = 13.57),
            Transakcje(etykieta = "Pensja z pracy", ilość = 3500.00),
            Transakcje(etykieta = "Galeria Zakupy", ilość = -280.00),
            Transakcje(etykieta = "Kwiaty dla żony", ilość = 67.00),

        )

        transakcjeAdapter = TransakcjeAdapter(transakcje)
        linearLayoutManager = LinearLayoutManager(this)

        val widok = findViewById<RecyclerView>(R.id.widok)

        widok.apply {
            adapter = transakcjeAdapter
            layoutManager = linearLayoutManager
        }

        updateTablicy()
    }

    private fun updateTablicy(){
        val całkowitaIlość:Double = transakcje.map { it.ilość }.sum()
        val budżetIlość:Double = transakcje.filter { it.ilość > 0 }.map { it.ilość }.sum()
        val wydadtkiIlość:Double  = całkowitaIlość - budżetIlość

        val saldo = findViewById<TextView>(R.id.saldo)
        val budżet = findViewById<TextView>(R.id.budżet)
        val wydadki = findViewById<TextView>(R.id.wydatki)

        saldo.text = "%.2f zł".format(całkowitaIlość)
        budżet.text = "%.2f zł".format(budżetIlość)
        wydadki.text = "%.2f zł".format(wydadtkiIlość)
    }
}
