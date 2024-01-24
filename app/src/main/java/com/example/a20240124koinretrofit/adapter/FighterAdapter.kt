package com.example.a20240124koinretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a20240124koinretrofit.databinding.HomeItemBinding
import com.example.a20240124koinretrofit.model.MovieModel

class FighterAdapter() :
    RecyclerView.Adapter<FighterAdapter.ViewHolder>() {
    inner class ViewHolder(val homeItemBinding: HomeItemBinding) :
        RecyclerView.ViewHolder(homeItemBinding.root) {

    }

     var list = listOf<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (list.isEmpty()) {
            0
        } else {
            list.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.homeItemBinding.apply {
            imageView.load(item.url) {
                crossfade(true)
                crossfade(1000)
            }
            tvTitle.text = item.name
            tvDescription.text = item.id.toString()
        }
    }
}