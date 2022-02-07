package com.matdev.tam_projekt

import com.matdev.tam_projekt.Model.Transakcje
import org.junit.Before

class TransakcjeTest {
    private lateinit var cut: Transakcje

    private val id = 0

    private val etykieta = "etykieta"

    private val ilość = 0.0

    private val opis = "opis"

    @Before
    fun setUp() {
        cut = Transakcje(id, etykieta, ilość, opis)
    }

}
