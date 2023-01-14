package com.example.source_rezacahyanugraha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.source_rezacahyanugraha.api.ApiInterface
import com.example.source_rezacahyanugraha.model.DataResponse
import com.example.source_rezacahyanugraha.room.DataDatabase


class DataRepository(
    private val apiInterface: ApiInterface,
    private val dataDatabase: DataDatabase
) {

    private val modelLiveData = MutableLiveData<DataResponse>()
    val data: LiveData<DataResponse>
        get() = modelLiveData


    suspend fun getData() {
        val result = apiInterface.getData()
        if (result.body() != null) {
            dataDatabase.dataDao().insertDatas(result.body()!!.data)


            modelLiveData.postValue(result.body())
        }
    }

//    suspend fun deleteData(){
    //        val result = apiInterface.getData()
    //        if (result.body() != null){
    //
    //        }
    //    }

}