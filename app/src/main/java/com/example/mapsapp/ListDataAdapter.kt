package com.example.mapsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.data.Data
import java.util.Locale

class ListDataAdapter (private var listData: ArrayList<Data>) : RecyclerView.Adapter<ListDataAdapter.ListViewHolder>() {

    private var fullListData: ArrayList<Data> = ArrayList(listData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (korban, bantuan, lokasi, tahun) = listData[position]
        holder.tvLokasi.text =  "Lokasi : " + lokasi
        holder.tvKorban.text =  "Jumlah Korban : " +korban + " Jiwa"
        holder.tvBantuan.text = "Jumlah Bantuan : " + bantuan+" L"
        holder.tvTahun.text = "Tahun : " + tahun
    }

    fun filterList(query: String) {
        val filteredList = ArrayList<Data>()
        if (query.isEmpty()) {
            filteredList.addAll(fullListData)
        } else {
            val filterPattern = query.lowercase(Locale.getDefault()).trim()
            for (item in fullListData) {
                if (item.korban.lowercase(Locale.getDefault()).contains(filterPattern) ||
                    item.bantuan.lowercase(Locale.getDefault()).contains(filterPattern) ||
                    item.lokasi.lowercase(Locale.getDefault()).contains(filterPattern) ||
                    item.tahun.lowercase(Locale.getDefault()).contains(filterPattern)) {
                    filteredList.add(item)
                }
            }
        }
        listData = filteredList
        notifyDataSetChanged()
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLokasi: TextView = itemView.findViewById(R.id.tv_item_lokasi)
        val tvKorban: TextView = itemView.findViewById(R.id.tv_item_korban)
        val tvBantuan: TextView = itemView.findViewById(R.id.tv_item_bantuan)
        val tvTahun : TextView = itemView.findViewById(R.id.tvtahun)
    }

}