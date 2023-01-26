package com.example.source_rezacahyanugraha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.source_rezacahyanugraha.model.ModelData
import com.example.source_rezacahyanugraha.room.DataDatabase
import com.example.source_rezacahyanugraha.viewsModel.DataViewModel
import com.example.source_rezacahyanugraha.viewsModel.DataViewModelFactory

class AddActivity: AppCompatActivity() {
    private lateinit var etNik: EditText
    private lateinit var etNama: EditText
    private lateinit var etUmur: EditText
    private lateinit var etKota: EditText
    private lateinit var btnAddData: Button

    private lateinit var dataViewsModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)

        etNik = findViewById(R.id.etNik)
        etNama = findViewById(R.id.etNama)
        etUmur = findViewById(R.id.etUmur)
        etKota = findViewById(R.id.etKota)
        btnAddData = findViewById(R.id.btnAddData)

        btnAddData.setOnClickListener {
            val nik = etNik.text.toString()
            val nama = etNama.text.toString()
            val umur = etUmur.text.toString()
            val kota = etKota.text.toString()

            val user = ModelData(0, nik, nama, umur, kota)
            val repository = (application as MyApplication).dataRepository

            dataViewsModel = ViewModelProvider(this,DataViewModelFactory(repository)).get(DataViewModel::class.java)
            dataViewsModel.data.observe(this, Observer {
                dataViewsModel.addData(user)
            })

            Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}