package com.example.source_rezacahyanugraha.api

import com.example.source_rezacahyanugraha.model.DataResponse

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("datadummy.php")
    suspend fun getData(): Response<DataResponse>
}