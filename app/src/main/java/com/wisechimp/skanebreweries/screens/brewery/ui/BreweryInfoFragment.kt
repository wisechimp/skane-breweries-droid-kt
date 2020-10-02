package com.wisechimp.skanebreweries.screens.brewery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.firebase.storage.FirebaseStorage
import com.wisechimp.skanebreweries.BuildConfig
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.adapters.GlideApp
import com.wisechimp.skanebreweries.database.Brewery
import com.wisechimp.skanebreweries.databinding.FragmentBreweryInfoBinding
import com.wisechimp.skanebreweries.screens.brewery.BreweryInfoViewModel
import com.wisechimp.skanebreweries.utils.customActionBar
import kotlinx.android.synthetic.main.fragment_brewery_info.*
import timber.log.Timber

class BreweryInfoFragment: Fragment() {

    private val breweryArgs: BreweryInfoFragmentArgs by navArgs()
    private lateinit var chosenBrewery: Brewery
    private val viewModel: BreweryInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        viewModel.chosenBrewery = breweryArgs.brewery
        chosenBrewery = viewModel.chosenBrewery!!

        val binding: FragmentBreweryInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_brewery_info, container, false)

        binding.breweryInfoViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customActionBar(activity as AppCompatActivity, chosenBrewery.name!!)

        val storageReference: FirebaseStorage = FirebaseStorage.getInstance()
        val breweryImageUrl: String = "gs://skane-breweries.appspot.com/skane-brewery-images/" + chosenBrewery.imageFileName

        val imageReference = storageReference.getReferenceFromUrl(breweryImageUrl)
        GlideApp.with(this)
            .load(imageReference)
            .into(breweryImageView)


        breweryVisitButt.setOnClickListener(Navigation.createNavigateOnClickListener(
            BreweryInfoFragmentDirections.actionBreweryInfoFragmentToBreweryWebsiteFragment(
                chosenBrewery.addressUrl!!,
                chosenBrewery.name!!
            )
        ))
    }

}