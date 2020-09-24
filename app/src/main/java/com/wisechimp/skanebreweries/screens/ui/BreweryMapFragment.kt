package com.wisechimp.skanebreweries.screens.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.wisechimp.skanebreweries.R
import kotlinx.android.synthetic.main.fragment_brewery_map.*

class BreweryMapFragment : Fragment(), MapboxMap.OnMapClickListener {

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
            mapboxMap.setStyle(Style.Builder().fromUri("mapbox://styles/wisechimp/ckfcbn7vt1sgl19mrfr9nmqz6"))

            mapboxMap.addOnMapClickListener(this)
        }
    }

    override fun onMapClick(point: LatLng): Boolean {
        val testToast = Toast.makeText(this.context, point.toString(), LENGTH_LONG)
        testToast.show()
        return true
    }
}