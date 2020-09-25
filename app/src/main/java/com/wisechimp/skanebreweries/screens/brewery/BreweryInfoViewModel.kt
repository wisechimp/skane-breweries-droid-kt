package com.wisechimp.skanebreweries.screens.brewery

import androidx.lifecycle.ViewModel
import com.wisechimp.skanebreweries.database.Brewery

class BreweryInfoViewModel: ViewModel() {
    var chosenBrewery: Brewery? = null
}