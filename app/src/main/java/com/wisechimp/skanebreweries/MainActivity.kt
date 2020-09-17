package com.wisechimp.skanebreweries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mapbox.mapboxsdk.Mapbox
import kotlinx.android.synthetic.main.fragment_tab_menu_layout.*

const val TAG : String = "Main Activity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)

        setContentView(R.layout.activity_main)

        val db = Firebase.firestore
        db.collection("skane-breweries")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}