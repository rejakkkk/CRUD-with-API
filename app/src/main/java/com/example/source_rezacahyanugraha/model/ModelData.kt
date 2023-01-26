package com.example.source_rezacahyanugraha.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class ModelData(
    @PrimaryKey (autoGenerate = true) var id: Int =0,
    val nik:String,
    val nama: String?,
    val umur: String,
    val kota:String
)