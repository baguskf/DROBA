package com.example.mapsapp.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.ListDataAdapter
import com.example.mapsapp.R
import com.example.mapsapp.databinding.Fragment2019Binding
import com.example.mapsapp.databinding.Fragment2020Binding


// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class Fragment_2019 : Fragment() {

    private var _binding: Fragment2019Binding? = null
    private val binding get() = _binding!!
    private lateinit var rvData: RecyclerView
    private val list = ArrayList<Data>()
    private lateinit var listDataAdapter: ListDataAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment2019Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        rvData = binding.recyclerView
        rvData.setHasFixedSize(true)
        rvData.layoutManager = LinearLayoutManager(requireContext())

        list.addAll(getListHeroes())
        listDataAdapter = ListDataAdapter(list)
        rvData.adapter = listDataAdapter
    }

    fun filterList(query: String) {
        listDataAdapter.filterList(query)
    }
    private fun getListHeroes(): ArrayList<Data> {
        val korban = resources.getStringArray(R.array.korban2019)
        val banutan = resources.getStringArray(R.array.Bantuan2019)
        val lokasi = resources.getStringArray(R.array.lokasi2019)
        val tahun = resources.getStringArray(R.array.Tahun2019)
        val listData = ArrayList<Data>()
        for (i in korban.indices) {
            val data = Data(korban[i], banutan[i], lokasi[i], tahun[i])
            listData.add(data)
        }
        return listData
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}