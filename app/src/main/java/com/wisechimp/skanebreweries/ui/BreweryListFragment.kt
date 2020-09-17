package com.wisechimp.skanebreweries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.adapters.BreweryListRVAdapter
import kotlinx.android.synthetic.main.fragment_brewery_list.view.*

class BreweryListFragment : Fragment() {

    private val breweries = arrayOf("Uncharted Brewery", "Some other Brewery", "A third brewery")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_brewery_list, container, false)

        view.breweriesList.layoutManager = LinearLayoutManager(activity)
        view.breweriesList.adapter = BreweryListRVAdapter(breweries)
        return view
    }
}