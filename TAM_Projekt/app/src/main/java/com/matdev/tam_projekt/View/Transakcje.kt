package com.matdev.tam_projekt.View

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "transakcje")
data class Transakcje(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val etykieta: String,
    val ilość: Double,
    val opis: String): Serializable{
}