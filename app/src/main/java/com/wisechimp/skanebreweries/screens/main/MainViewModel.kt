package com.wisechimp.skanebreweries.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wisechimp.skanebreweries.database.Brewery

class MainViewModel: ViewModel() {
    private val _title = MutableLiveData<String>()
    val title : LiveData<String>
        get() = _title

    fun updateActionBarTitle(title: String) = _title.postValue(title)

    private val _navigateToBrewery = MutableLiveData<Brewery>()
    val navigateToBrewery: LiveData<Brewery>
        get() = _navigateToBrewery

    fun doneNavigating() {
        _navigateToBrewery.value = null
    }
}