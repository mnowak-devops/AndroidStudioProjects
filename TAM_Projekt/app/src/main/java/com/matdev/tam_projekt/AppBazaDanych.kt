package com.matdev.tam_projekt

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Transakcje::class), version = 1)
abstract class AppBazaDanych : RoomDatabase(){
    abstract fun transakcjeDao() : TransakcjeDao
}