package com.example.uf1_proyecto.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uf1_proyecto.data.database.entities.QuoteEntity

@Dao
interface InterfaceDao {
    @Query("SELECT * FROM Recordatorios ORDER BY fecha DESC")
    suspend fun getAllQuotes():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)
}