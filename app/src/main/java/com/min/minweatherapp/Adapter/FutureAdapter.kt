package com.min.minweatherapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.min.minweatherapp.Domain.FutureDomain
import com.min.minweatherapp.databinding.ViewholderFutureBinding

/**
 * Created by Min on 2025/1/17.
 */
class FutureAdapter(private val items: ArrayList<FutureDomain>) :
    RecyclerView.Adapter<FutureAdapter.Viewholder>() {

    private lateinit var context: Context

    class Viewholder(val binding: ViewholderFutureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutureAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderFutureBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: FutureAdapter.Viewholder, position: Int) {
        val item = items[position]

        holder.binding.apply {
            dayTxt.text = item.day
            statusTxt.text = item.status
            lowTxt.text = item.lowTemp.toString()
            highTxt.text = item.highTemp.toString()

            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.picPath,
                "drawable",
                context.packageName
            )

            Glide.with(context)
                .load(drawableResourceId)
                .into(pic)
        }
    }

    override fun getItemCount(): Int = items.size
}