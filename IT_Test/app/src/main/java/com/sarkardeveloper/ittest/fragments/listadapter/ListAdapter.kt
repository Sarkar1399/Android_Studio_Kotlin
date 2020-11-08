package com.sarkardeveloper.ittest.fragments.listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarkardeveloper.ittest.modul.ProgressDb
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var progressList = emptyList<ProgressDb>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return progressList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = progressList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.historyResultText.text = currentItem.nameTest
        holder.itemView.historyResultTest.text = currentItem.textTest
        holder.itemView.historyProgressBar.progress = currentItem.testProgress.toInt()
    }

    fun setData(test: List<ProgressDb>){
        this.progressList = test
        notifyDataSetChanged()
    }
}