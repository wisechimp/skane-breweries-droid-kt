package com.wisechimp.skanebreweries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class BreweryScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_brewery_info)
        setSupportActionBar(findViewById(R.id.toolbar_brewery))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}