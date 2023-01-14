package com.example.source_rezacahyanugraha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.source_rezacahyanugraha.model.ModelData

class RecyclerViewAdapter(val listener: RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var dataList: List<ModelData>? = null

    fun setDataList(dataList: List<ModelData>?){
        this.dataList = dataList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(dataList?.get(position)!!)
        }
        holder.bind(dataList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (dataList == null) return 0
        else return dataList?.size!!
    }

    class MyViewHolder(view: View, val listener: RowClickListener): RecyclerView.ViewHolder(view){
        val ivDelete = view.findViewById<ImageView>(R.id.iv_delete)
        val tvNik = view.findViewById<TextView>(R.id.tv_nik)
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvUmur = view.findViewById<TextView>(R.id.tv_umur)
        val tvKota = view.findViewById<TextView>(R.id.tv_kota)
        fun bind(data: ModelData){
            tvNik.text = data.nik
            tvNama.text = data.nama
            tvUmur.text = data.umur
            tvKota.text = data.kota

            ivDelete.setOnClickListener{
                listener.onDeleteClickListener(data)
            }

        }
    }

    interface RowClickListener{
        fun onDeleteClickListener(data: ModelData)
        fun onItemClickListener(data: ModelData)
    }
}