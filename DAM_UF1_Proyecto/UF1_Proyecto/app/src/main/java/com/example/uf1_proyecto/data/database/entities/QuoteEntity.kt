package com.example.uf1_proyecto.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "Recordatorios")
data class QuoteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "descripcion") val descripcion:String,
    @ColumnInfo(name = "fecha")val fecha: Date
)