package com.min.modulebweather.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.min.minweatherapp.Domain.CityDomain
import com.min.minweatherapp.databinding.ViewholderCityBinding

/**
 *Created by ming on 2025/2/24.
 */
class CardCityAdapter(
    private val items: ArrayList<CityDomain>,
    private val onItemClickListener: (CityDomain) -> Unit
) : RecyclerView.Adapter<CardCityAdapter.Viewholder>() {

    private lateinit var context: Context

    class Viewholder(val binding: ViewholderCityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding = ViewholderCityBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            ctCity.text = item.cityName
            ctTemp.text = "${item.temp}˚C"
            ctFs.text = "${item.wind}Km/h"
            ctJy.text = "${item.rain}%"
            ctSd.text = "${item.humidity}%"

            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.picPath?:"sunny",
                "drawable",
                context.packageName
            )

            Glide.with(context)
                .load(drawableResourceId)
                .into(ctPic)

            holder.itemView.setOnClickListener {
                onItemClickListener(item)
            }

        }


    }
}