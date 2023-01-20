package com.example.source_rezacahyanugraha

import android.app.Application
import com.example.source_rezacahyanugraha.api.ApiInterface
import com.example.source_rezacahyanugraha.api.RetrofitNetwork
import com.example.source_rezacahyanugraha.repository.DataRepository
import com.example.source_rezacahyanugraha.room.DataDatabase

class MyApplication: Application() {

    lateinit var dataRepository: DataRepository
    override fun onCreate() {
        super.onCreate()


        val apiInterface = RetrofitNetwork.getInstance().create(ApiInterface::class.java)

        val database = DataDatabase.getDatabase(applicationContext)

        dataRepository = DataRepository(apiInterface, database)

    }
}