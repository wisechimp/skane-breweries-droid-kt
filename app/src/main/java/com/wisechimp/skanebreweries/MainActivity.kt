package com.wisechimp.skanebreweries

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mapbox.mapboxsdk.Mapbox
import kotlinx.android.synthetic.main.fragment_tab_menu_layout.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_tabs)

        val viewModel: MainViewModel by viewModels()
        viewModel.title.observe(this, Observer {
            toolbar_tabs.title = it
            Timber.d("Are we observing?")
        })
    }
}
