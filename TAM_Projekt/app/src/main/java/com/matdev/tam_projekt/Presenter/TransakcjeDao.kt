package com.matdev.tam_projekt.Presenter

import androidx.room.*
import com.matdev.tam_projekt.Model.Transakcje

@Dao
interface TransakcjeDao {
    @Query("SELECT * from transakcje ")
    fun getAll(): List<Transakcje>

    @Insert
    fun insertAll( vararg transakcje: Transakcje)

    @Delete
    fun delete(transakcje: Transakcje)

    @Update
    fun update (vararg transakcje: Transakcje)
}