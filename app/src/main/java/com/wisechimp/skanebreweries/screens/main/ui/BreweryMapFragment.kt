package com.wisechimp.skanebreweries.screens.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wisechimp.skanebreweries.R
import com.wisechimp.skanebreweries.database.Brewery
import com.wisechimp.skanebreweries.utils.navigateToBrewery
import kotlinx.android.synthetic.main.fragment_brewery_map.*
import timber.log.Timber

class BreweryMapFragment : Fragment(), MapboxMap.OnMapClickListener {

    private lateinit var mapboxMap: MapboxMap
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_brewery_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = breweryMapView
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync { mapboxMap ->
            this.mapboxMap = mapboxMap
            mapboxMap.setStyle(Style.Builder().fromUri("mapbox://styles/wisechimp/ckfcbn7vt1sgl19mrfr9nmqz6"))

            mapboxMap.addOnMapClickListener(this)
        }
    }

    override fun onMapClick(point: LatLng): Boolean {
        Timber.d(point.toString())
        val pixel = mapboxMap.projection.toScreenLocation(point)
        val features = mapboxMap.queryRenderedFeatures(pixel, "skane-breweries")

        if (features.size > 0) {
            val feature = features[0]
            val clickedBrewery: Brewery? =  parseBreweryFeatureJson(feature.properties().toString())
            navigateToBrewery(activity as AppCompatActivity, clickedBrewery!!)
        }
        return true
    }

    private fun parseBreweryFeatureJson(string: String): Brewery? {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<Brewery> = moshi.adapter(Brewery::class.java)

        val brewery = jsonAdapter.fromJson(string)
        Timber.d(brewery.toString())
        return brewery
    }
}