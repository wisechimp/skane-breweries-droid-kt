package com.wisechimp.skanebreweries.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.adapters.BreweryListRVAdapter
import com.wisechimp.skanebreweries.database.Brewery
import kotlinx.android.synthetic.main.fragment_brewery_list.view.*

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

        return view
    }

    private fun accessFirebaseDatabase(breweriesList: RecyclerView) {
        database = FirebaseDatabase.getInstance().reference

        val breweryListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    breweries.clear()
                    for (e in snapshot.children) {
                        val brewery = e.getValue(Brewery::class.java)
                        if (brewery != null) {
                            breweries.add(brewery)
                            Log.d("Brewery", brewery.toString())
                        }
                    }
                    breweriesList.adapter = BreweryListRVAdapter(breweries)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("Brewery List", "Adding brewery SNAFU", error.toException())
            }
        }
        database.addValueEventListener(breweryListener)
        Log.d("BreweryListFragment", breweries.toString())
    }
}