package com.wisechimp.skanebreweries.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.wisechimp.skanebreweries.R.drawable.back_arrow_ios
import com.wisechimp.skanebreweries.database.Brewery
import com.wisechimp.skanebreweries.screens.main.ui.BreweryMapFragment
import com.wisechimp.skanebreweries.screens.main.ui.TabbedMenuFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*

fun customActionBar (activity: AppCompatActivity, string: String) {
    val backArrowReference = back_arrow_ios
    activity.supportActionBar?.setHomeAsUpIndicator(backArrowReference)
    activity.toolbar.title = string
}

fun navigateToBrewery (activity: AppCompatActivity, brewery: Brewery) {
    val clickBrewery = TabbedMenuFragmentDirections.actionTabbedMenuFragmentToBreweryInfoFragment(
        brewery
    )
    findNavController(activity.navHostFragment).navigate(clickBrewery)
}