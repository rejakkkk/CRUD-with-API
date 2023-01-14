package com.example.source_rezacahyanugraha.viewsModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.source_rezacahyanugraha.repository.DataRepository

class DataViewModelFactory(private val dataRepository: DataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(dataRepository) as T
    }
}