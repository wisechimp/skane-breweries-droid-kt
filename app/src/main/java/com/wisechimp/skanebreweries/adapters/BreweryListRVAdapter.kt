package com.wisechimp.skanebreweries.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wisechimp.skanebreweries.R
import kotlinx.android.synthetic.main.brewery_rv_row.view.*

class BreweryListRVAdapter(private val breweries: Array<String>): RecyclerView.Adapter<BreweryListRVAdapter.BreweryListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreweryListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brewery_rv_row, parent, false)
        return BreweryListViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: BreweryListViewHolder,
        position: Int
    ) {
        holder.itemView.brewery_rv_row_textView.text = breweries[position]
    }

    override fun getItemCount() =breweries.size

    class BreweryListViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("Brewery RV", "I want this brewery!")
        }
    }
}