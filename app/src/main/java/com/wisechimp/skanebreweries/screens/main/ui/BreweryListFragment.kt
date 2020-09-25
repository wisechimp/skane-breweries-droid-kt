package com.wisechimp.skanebreweries.screens.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.adapters.BreweryClickListener
import com.wisechimp.skanebreweries.adapters.BreweryListRVAdapter
import com.wisechimp.skanebreweries.database.Brewery
import kotlinx.android.synthetic.main.fragment_brewery_list.view.*
import timber.log.Timber

class BreweryListFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private val breweries: MutableList<Brewery> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_brewery_list, container, false)

        view.breweriesList.setHasFixedSize(true)
        view.breweriesList.layoutManager = LinearLayoutManager(activity)
        accessFirebaseDatabase(view.breweriesList)
        Timber.d("View created?")

        return view
    }

    private fun accessFirebaseDatabase(breweriesList: RecyclerView) {
        database = FirebaseDatabase.getInstance().reference
        Timber.d("Database Created")

        val breweryListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    breweries.clear()
                    for (e in snapshot.children) {
                        val brewery = e.getValue(Brewery::class.java)
                        if (brewery != null) {
                            breweries.add(brewery)
                            Timber.d(brewery.toString())
                        }
                    }
                    breweriesList.adapter = BreweryListRVAdapter(breweries, BreweryClickListener {
                        val clickedBrewery = it
                        val clickBrewery = TabbedMenuFragmentDirections.actionTabbedMenuFragmentToBreweryInfoActivity(clickedBrewery)
                        findNavController().navigate(clickBrewery)
                    })
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Timber.w(error.toException(), "Adding brewery SNAFU")
            }
        }
        database.addValueEventListener(breweryListener)
        Timber.d(breweries.toString())
    }
}