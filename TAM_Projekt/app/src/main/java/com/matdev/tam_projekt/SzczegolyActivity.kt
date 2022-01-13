package com.matdev.tam_projekt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SzczegolyActivity : AppCompatActivity() {
    private lateinit var transakcja : Transakcje
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_szczegoly)


        val zmianaTransakciButton = findViewById<Button>(R.id.zmianaTransakcjiButton)
        val labelInput = findViewById<TextInputEditText>(R.id.labelInput)
        val ilośćInput = findViewById<TextInputEditText>(R.id.ilośćInput)
        val etykietaLayout = findViewById<TextInputLayout>(R.id.etykietaLayout)
        val ilośćLayout = findViewById<TextInputLayout>(R.id.ilośćLayout)
        val closeButton = findViewById<ImageButton>(R.id.closeButton)
        val opisInput = findViewById<TextInputEditText>(R.id.opisInput)
        val rootView = findViewById<View>(R.id.rootView)

        transakcja = intent.getSerializableExtra("transakcja") as Transakcje

        labelInput.setText(transakcja.etykieta)
        ilośćInput.setText(transakcja.ilość.toString())
        opisInput.setText(transakcja.opis)

        rootView.setOnClickListener{
            this.window.decorView.clearFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }


        labelInput.addTextChangedListener {
            zmianaTransakciButton.visibility = View.VISIBLE
            if (it!!.count() > 0)
                etykietaLayout.error = null
        }
        ilośćInput.addTextChangedListener {
            zmianaTransakciButton.visibility = View.VISIBLE
            if (it!!.count() > 0)
                ilośćLayout.error = null
        }
        opisInput.addTextChangedListener {
            zmianaTransakciButton.visibility = View.VISIBLE

        }


        zmianaTransakciButton.setOnClickListener{
            val label : String = labelInput.text.toString()
            val opis : String = opisInput.text.toString()
            val ilość : Double? = ilośćInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                etykietaLayout.error = "Proszę podać prawidłową etykiete transakcji!"

            else if(ilość == null)
                ilośćLayout.error = "Prosze podać poprawną wartość transakcji!"
            else{
                val transakcje = Transakcje(transakcja.id, label,ilość,opis)
                zmiana(transakcje)
            }

        }
        closeButton.setOnClickListener{
            finish()
        }
    }
    private fun zmiana(transakcje:Transakcje){
        val db: AppBazaDanych = Room.databaseBuilder(this, AppBazaDanych::class.java, "transakcje").build()

        GlobalScope.launch {
            db.transakcjeDao().update(transakcje)
            finish()
        }
    }

}