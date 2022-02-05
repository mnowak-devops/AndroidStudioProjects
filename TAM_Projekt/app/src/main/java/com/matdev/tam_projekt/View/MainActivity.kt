package com.matdev.tam_projekt.View

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.matdev.tam_projekt.Model.AppBazaDanych
import com.matdev.tam_projekt.R
import com.matdev.tam_projekt.Presenter.TransakcjeAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var usunięteTransakcje: Transakcje
    private lateinit var transakcje: List<Transakcje>
    private lateinit var stareTransakcje: List<Transakcje>
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

        // przeciagnij w celu usunięcia
        val itemTouchHelper = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                usuwanieTransakcji(transakcje[viewHolder.adapterPosition])
            }

        }
        val swipeHelper = ItemTouchHelper(itemTouchHelper)
        swipeHelper.attachToRecyclerView(widok)
        val addTransakcjeButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(
            R.id.addTransakcjeButton
        )

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

    private fun cofnijUsunięcie(){
        GlobalScope.launch {
            db.transakcjeDao().insertAll(usunięteTransakcje)

            transakcje = stareTransakcje

            runOnUiThread() {
                transakcjeAdapter.setData(transakcje)
                updateTablicy()

            }
        }
    }
    private fun pokazSnackBar(){
        val view = findViewById<View>(R.id.coordinator)
        val snackbar = Snackbar.make(view, "Transakcja usunięta!", Snackbar.LENGTH_LONG)
        snackbar.setAction("Cofnij"){
            cofnijUsunięcie()
        }
            .setActionTextColor(ContextCompat.getColor(this, R.color.red))
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .show()
    }
    private fun usuwanieTransakcji(transakcja: Transakcje){
        usunięteTransakcje = transakcja
        stareTransakcje = transakcje

        GlobalScope.launch {
            db.transakcjeDao().delete(transakcja)

            transakcje = transakcje.filter{ it.id != transakcja.id}
            runOnUiThread{
                updateTablicy()
                transakcjeAdapter.setData(transakcje)
                pokazSnackBar()
        }

        }
    }

    override fun onResume() {
        super.onResume()
        fetchAll()
    }
}
