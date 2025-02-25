package com.min.modulebweather.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.min.minweatherapp.databinding.ViewholderFutureBinding
import com.min.modulebweather.Domain.FutureDomain

/**
 *Created by ming on 2025/2/25.
 */
class FutureAdapter(private var items: ArrayList<FutureDomain>) :
    RecyclerView.Adapter<FutureAdapter.Viewholder>() {

    private lateinit var context: Context

    class Viewholder(val binding: ViewholderFutureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding = ViewholderFutureBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]

        holder.binding.apply {
            ftXq.text = item.day
            ftWqk.text = item.status
            ftHTemp.text = item.highTemp.toString()
            ftLTemp.text = item.lowTemp.toString()

            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.picPath?:"sunny",
                "drawable",
                context.packageName
            )

            Glide.with(context)
                .load(drawableResourceId)
                .into(ftImg)
        }
    }
}