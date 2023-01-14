package com.example.source_rezacahyanugraha.room

import androidx.room.*
import com.example.source_rezacahyanugraha.model.ModelData


@Dao
interface RoomDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDatas(data: List<ModelData>)

    @Delete
    suspend fun deleteDatas(data: List<ModelData>)

    @Query("SELECT * FROM data")
    suspend fun getDatas() : List<ModelData>
}