package com.sarkardeveloper.ittest.fragments.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sarkardeveloper.ittest.viewmodel.ProgressViewModel
import com.sarkardeveloper.ittest.fragments.listadapter.ListAdapter
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var mProgressViewModel: ProgressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_history, container, false)

        //RecycleView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ProgressViewModel
        mProgressViewModel = ViewModelProvider(this).get(ProgressViewModel::class.java)
        mProgressViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            test -> adapter.setData(test)
        })

        return view
    }
}