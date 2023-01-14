package com.example.source_rezacahyanugraha.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.source_rezacahyanugraha.model.ModelData

@Database(entities = [ModelData::class], version = 1)
abstract class DataDatabase : RoomDatabase() {

    abstract fun dataDao() : RoomDao

    companion object{
        private var INSTANCE : DataDatabase? = null

        fun getDatabase(context: Context): DataDatabase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    DataDatabase::class.java,
                    "dataDB"
                ).build()
            }

            return INSTANCE!!
        }
    }
}