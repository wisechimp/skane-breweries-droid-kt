package com.wisechimp.skanebreweries.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.wisechimp.skanebreweries.database.Brewery

@BindingAdapter("breweryNameString")
fun TextView.setBreweryNameString(item: Brewery) {
    item.let {
        text = item.name
    }
}