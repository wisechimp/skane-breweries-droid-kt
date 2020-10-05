package com.wisechimp.skanebreweries.screens.brewerywebview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.utils.customActionBar
import kotlinx.android.synthetic.main.fragment_brewery_website.*
import timber.log.Timber

class BreweryWebsiteFragment : Fragment() {

    private val chosenBreweryArgs: BreweryWebsiteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_brewery_website, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customActionBar(activity as AppCompatActivity, chosenBreweryArgs.breweryAddressName)
        val breweryWebsiteAddress = chosenBreweryArgs.breweryAddressUrl
        Timber.d(breweryWebsiteAddress)
        breweryWebView.loadUrl(breweryWebsiteAddress)
    }
}