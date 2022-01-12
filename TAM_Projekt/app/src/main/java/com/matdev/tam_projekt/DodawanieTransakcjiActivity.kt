package com.matdev.tam_projekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class DodawanieTransakcjiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodawanie_transakcji)

        val dodanieTransakciButton = findViewById<Button>(R.id.dodanieTransakcjiButton)
        val labelInput = findViewById<TextInputEditText>(R.id.labelInput)
        val ilośćInput = findViewById<TextInputEditText>(R.id.ilośćInput)
        val etykietaLayout = findViewById<TextInputLayout>(R.id.etykietaLayout)
        val ilośćLayout = findViewById<TextInputEditText>(R.id.ilośćLayout)

        dodanieTransakciButton.setOnClickListener{
            val label : String = labelInput.text.toString()
            val ilość : Double? = ilośćInput.text.toString().toDoubleOrNull()

            //if(label.isEmpty())
                //etykietaLayout.error = "Proszę podać prawidłową etykiete transakcji!"

            //if(ilość == null)
                //ilośćLayout.error = "Prosze podać poprawną wartość transakcji!"
        }
    }
}