package com.matdev.tam_projekt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transakcje")
data class Transakcje(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val etykieta: String,
    val ilość: Double,
    val opis: String) {
}