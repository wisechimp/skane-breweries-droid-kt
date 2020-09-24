package com.wisechimp.skanebreweries.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wisechimp.skanebreweries.database.Brewery
import com.wisechimp.skanebreweries.databinding.BreweryRvRowBinding
import timber.log.Timber

class BreweryListRVAdapter(private val breweries: MutableList<Brewery>, private val clickListener: BreweryClickListener): RecyclerView.Adapter<BreweryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreweryViewHolder {
        return BreweryViewHolder.from(parent)
    }

    override fun onBindViewHolder(
        holder: BreweryViewHolder,
        position: Int
    ) {
        holder.bind(breweries[position], clickListener)
        Timber.d(breweries[position].name)
    }

    override fun getItemCount() =breweries.size
}

class BreweryViewHolder private constructor(private val binding: BreweryRvRowBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(item: Brewery, clickListener: BreweryClickListener) {
        binding.brewery = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): BreweryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BreweryRvRowBinding.inflate(layoutInflater, parent, false)
            return BreweryViewHolder(binding)
        }
    }
}

class BreweryClickListener(val clickListener: (brewery: Brewery) -> Unit) {
    fun onClick(brewery: Brewery) = clickListener(brewery)
}