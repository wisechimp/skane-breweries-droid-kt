package com.wisechimp.skanebreweries.screens.brewery

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.google.firebase.storage.FirebaseStorage
import com.wisechimp.skanebreweries.BuildConfig
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.adapters.GlideApp
import com.wisechimp.skanebreweries.database.Brewery
import com.wisechimp.skanebreweries.databinding.ActivityBreweryInfoBinding
import kotlinx.android.synthetic.main.activity_brewery_info.*
import timber.log.Timber

class BreweryInfoActivity: AppCompatActivity() {

    private val breweryArgs: BreweryInfoActivityArgs by navArgs()
    private lateinit var chosenBrewery: Brewery
    private val viewModel: BreweryInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        viewModel.chosenBrewery = breweryArgs.brewery
        chosenBrewery = viewModel.chosenBrewery!!

        val binding: ActivityBreweryInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_brewery_info)

        binding.breweryInfoViewModel = viewModel
        binding.lifecycleOwner = this

        setSupportActionBar(toolbar_brewery)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toolbarTitle: String? = chosenBrewery.name
        toolbar_brewery.title = toolbarTitle
        Timber.d(toolbarTitle)

        val storageReference: FirebaseStorage = FirebaseStorage.getInstance()
        val breweryImageUrl: String = "gs://skane-breweries.appspot.com/skane-brewery-images/" + chosenBrewery.imageFileName

        val imageReference = storageReference.getReferenceFromUrl(breweryImageUrl)
        GlideApp.with(this)
            .load(imageReference)
            .into(breweryImageView)
    }
}