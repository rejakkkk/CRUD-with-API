package com.example.source_rezacahyanugraha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.source_rezacahyanugraha.api.ApiInterface
import com.example.source_rezacahyanugraha.api.RetrofitNetwork
import com.example.source_rezacahyanugraha.model.ModelData
import com.example.source_rezacahyanugraha.repository.DataRepository
import com.example.source_rezacahyanugraha.viewsModel.DataViewModel
import com.example.source_rezacahyanugraha.viewsModel.DataViewModelFactory


class MainActivity : AppCompatActivity(), RecyclerViewAdapter.RowClickListener {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var dataViewsModel:DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter(this)
        recyclerview.adapter = recyclerViewAdapter

        initViewModel()
    }

    private fun initViewModel(){
        val repository = (application as MyApplication).dataRepository

        dataViewsModel = ViewModelProvider(this,DataViewModelFactory(repository)).get(DataViewModel::class.java)
        dataViewsModel.data.observe(this, Observer {
            recyclerViewAdapter.setDataList(it.data)
            recyclerViewAdapter.notifyDataSetChanged()
        })

    }

    override fun onDeleteClickListener(data: ModelData) {

    }

    override fun onItemClickListener(data: ModelData) {
    }


}