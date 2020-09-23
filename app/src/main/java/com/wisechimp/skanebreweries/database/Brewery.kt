package com.wisechimp.skanebreweries.database

data class Brewery(
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var founded: String = "",
    var location: String = "",
    var brewers: String = ""
)
