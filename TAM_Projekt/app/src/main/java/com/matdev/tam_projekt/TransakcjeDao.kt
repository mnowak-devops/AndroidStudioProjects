package com.matdev.tam_projekt

import androidx.room.*

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