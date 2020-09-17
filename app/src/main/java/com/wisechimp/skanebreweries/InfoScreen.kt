package com.wisechimp.skanebreweries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class InfoScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_app_info)
        setSupportActionBar(findViewById(R.id.toolbar_info))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}