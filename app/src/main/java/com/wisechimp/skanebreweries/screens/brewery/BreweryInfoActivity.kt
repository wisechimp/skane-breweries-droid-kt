package com.wisechimp.skanebreweries.screens.brewery

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.navArgs
import com.wisechimp.skanebreweries.BuildConfig
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.databinding.ActivityBreweryInfoBinding
import kotlinx.android.synthetic.main.activity_brewery_info.*
import timber.log.Timber

class BreweryInfoActivity: AppCompatActivity() {

    private val breweryArgs: BreweryInfoActivityArgs by navArgs()
    private val viewModel: BreweryInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        viewModel.chosenBrewery = breweryArgs.brewery

        val binding: ActivityBreweryInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_brewery_info)

        binding.breweryInfoViewModel = viewModel
        binding.lifecycleOwner = this

        setSupportActionBar(toolbar_brewery)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toolbarTitle: String? = viewModel.chosenBrewery!!.name
        toolbar_brewery.title = toolbarTitle

        Timber.d(toolbarTitle)
    }
}