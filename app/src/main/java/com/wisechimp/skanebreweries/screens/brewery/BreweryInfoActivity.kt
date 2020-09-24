package com.wisechimp.skanebreweries.screens.brewery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisechimp.skanebreweries.R
import kotlinx.android.synthetic.main.activity_brewery_info.*

class BreweryInfoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brewery_info)
        setSupportActionBar(toolbar_brewery)
    }
}