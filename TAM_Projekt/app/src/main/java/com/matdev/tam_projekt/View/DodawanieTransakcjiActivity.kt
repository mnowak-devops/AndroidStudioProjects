package com.matdev.tam_projekt.View

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.matdev.tam_projekt.Model.AppBazaDanych
import com.matdev.tam_projekt.Model.Transakcje
import com.matdev.tam_projekt.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DodawanieTransakcjiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodawanie_transakcji)

        val dodanieTransakciButton = findViewById<Button>(R.id.dodanieTransakcjiButton)
        val labelInput = findViewById<TextInputEditText>(R.id.labelInput)
        val ilośćInput = findViewById<TextInputEditText>(R.id.ilośćInput)
        val etykietaLayout = findViewById<TextInputLayout>(R.id.etykietaLayout)
        val ilośćLayout = findViewById<TextInputLayout>(R.id.ilośćLayout)
        val closeButton = findViewById<ImageButton>(R.id.closeButton)
        val opisInput = findViewById<TextInputEditText>(R.id.opisInput)

        labelInput.addTextChangedListener {
            if (it!!.count() > 0)
                etykietaLayout.error = null
        }
        ilośćInput.addTextChangedListener {
            if (it!!.count() > 0)
                ilośćLayout.error = null
        }


        dodanieTransakciButton.setOnClickListener{
            val label : String = labelInput.text.toString()
            val opis : String = opisInput.text.toString()
            val ilość : Double? = ilośćInput.text.toString().toDoubleOrNull()

            when {
                label.isEmpty() -> etykietaLayout.error = "Proszę podać prawidłową etykiete transakcji!"
                ilość == null -> ilośćLayout.error = "Prosze podać poprawną wartość transakcji!"
                else -> {
                    val transakcje = Transakcje(0, label,ilość,opis)
                    dodawanie(transakcje)
                }
            }

        }
        closeButton.setOnClickListener{
            finish()
        }
    }
    private fun dodawanie(transakcje: Transakcje){
        val db: AppBazaDanych = Room.databaseBuilder(this, AppBazaDanych::class.java, "transakcje").build()

        GlobalScope.launch {
            db.transakcjeDao().insertAll(transakcje)
            finish()
        }
    }

}