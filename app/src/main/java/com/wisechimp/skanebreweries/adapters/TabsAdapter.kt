package com.wisechimp.skanebreweries.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wisechimp.skanebreweries.ui.BreweryListFragment
import com.wisechimp.skanebreweries.ui.BreweryMapFragment

class TabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            BreweryMapFragment()
        } else {
            BreweryListFragment()
        }
    }
}