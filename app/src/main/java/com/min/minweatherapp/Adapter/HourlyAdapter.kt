package com.min.modulebweather.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.min.minweatherapp.databinding.ViewholderHourlyBinding
import com.min.modulebweather.Domain.HourlyModel

/**
 *Created by ming on 2025/2/23.
 */
class HourlyAdapter(private val items: ArrayList<HourlyModel>) :
    RecyclerView.Adapter<HourlyAdapter.Viewholder>() {

    private lateinit var context: Context

    class Viewholder(val binding: ViewholderHourlyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderHourlyBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: HourlyAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            hourTxt.text = item.hour
            tempTxt.text = "${item.temp}˚C"

            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.picPath?:"sunny",
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