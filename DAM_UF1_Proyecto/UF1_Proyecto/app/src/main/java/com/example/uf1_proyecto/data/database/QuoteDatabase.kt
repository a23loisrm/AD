package com.example.uf1_proyecto.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.uf1_proyecto.data.database.dao.InterfaceDao
import com.example.uf1_proyecto.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao():InterfaceDao
}