package com.matdev.tam_projekt.Model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matdev.tam_projekt.Presenter.TransakcjeDao


@Database(entities = arrayOf(Transakcje::class), version = 1)
abstract class AppBazaDanych : RoomDatabase(){
    abstract fun transakcjeDao() : TransakcjeDao
}