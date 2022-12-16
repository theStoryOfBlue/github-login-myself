package com.example.pureumgittest

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.DomainRepo
import com.example.pureumgittest.databinding.ItemsBinding

/**
 * 2022-12-15
 * pureum
 */
class Adapter : RecyclerView.Adapter<Adapter.RepoListViewHolder>() {

    var dataList = listOf<DomainRepo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class RepoListViewHolder(private val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(list : DomainRepo){
            binding.myid.text = list.id.toString()
            binding.myname.text = list.name
            binding.isprivate.text = list.isPrivate.toString()
            binding.langugage.text = list.language
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        Log.e(javaClass.simpleName, "@@@ onCreateViewHolder: ", )
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}