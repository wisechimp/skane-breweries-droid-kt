package com.wisechimp.skanebreweries.utils

import androidx.appcompat.app.AppCompatActivity
import com.wisechimp.skanebreweries.R.drawable.back_arrow_ios
import kotlinx.android.synthetic.main.activity_main.*

fun customActionBar (activity: AppCompatActivity, string: String) {
    val backArrowReference = back_arrow_ios
    activity.supportActionBar?.setHomeAsUpIndicator(backArrowReference)
    activity.toolbar.title = string
}