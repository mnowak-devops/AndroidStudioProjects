package com.matdev.tam_projekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var transakcje: List<Transakcje>
    private lateinit var transakcjeAdapter: TransakcjeAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var db: AppBazaDanych

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transakcje = arrayListOf()

        transakcjeAdapter = TransakcjeAdapter(transakcje)
        linearLayoutManager = LinearLayoutManager(this)

        db = Room.databaseBuilder(this, AppBazaDanych::class.java, "transakcje").build()

        val widok = findViewById<RecyclerView>(R.id.widok)

        widok.apply {
            adapter = transakcjeAdapter
            layoutManager = linearLayoutManager
        }


        val addTransakcjeButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.addTransakcjeButton)

        addTransakcjeButton.setOnClickListener{
            val intent = Intent(this, DodawanieTransakcjiActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchAll(){
       GlobalScope.launch {
           transakcje = db.transakcjeDao().getAll()

           runOnUiThread{
               updateTablicy()
               transakcjeAdapter.setData(transakcje)
           }
       }
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

    override fun onResume() {
        super.onResume()
        fetchAll()
    }
}
