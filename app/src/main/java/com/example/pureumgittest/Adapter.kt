package com.example.pureumgittest

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

    val dataList = arrayListOf<List<DomainRepo>>()

    inner class RepoListViewHolder(private val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(list : List<DomainRepo>, now : Int){
            binding.myid.text = list[now].id.toString()
            binding.myname.text = list[now].name
            binding.isprivate.text = list[now].isPrivate.toString()
            binding.langugage.text = list[now].language
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }

    override fun getItemCount(): Int = dataList.size
}