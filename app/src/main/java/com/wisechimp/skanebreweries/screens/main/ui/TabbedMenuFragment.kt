package com.wisechimp.skanebreweries.screens.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.adapters.TabsAdapter
import kotlinx.android.synthetic.main.fragment_tab_menu_layout.*

class TabbedMenuFragment: Fragment() {

    private lateinit var tabsAdapter: TabsAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_menu_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabsAdapter = TabsAdapter(this)

        viewPager = tabViewPager
        viewPager.isUserInputEnabled = false
        viewPager.adapter = tabsAdapter

        TabLayoutMediator(navTabLayout, viewPager) {
                tab, position->
            viewPager.setCurrentItem(tab.position, true)
            if (position == 0) {
                tab.text = "MAP"
            } else tab.text = "LIST"
        }.attach()
    }
}