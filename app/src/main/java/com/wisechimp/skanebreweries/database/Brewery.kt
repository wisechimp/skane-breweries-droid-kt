package com.wisechimp.skanebreweries.database

import android.os.Parcel
import android.os.Parcelable

data class Brewery(
    var id: Int = 0,
    var name: String? = "",
    var description: String? = "",
    var founded: String? = "",
    var location: String? = "",
    var brewers: String? = "",
    var imageFileName: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(founded)
        parcel.writeString(location)
        parcel.writeString(brewers)
        parcel.writeString(imageFileName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Brewery> {
        override fun createFromParcel(parcel: Parcel): Brewery {
            return Brewery(parcel)
        }

        override fun newArray(size: Int): Array<Brewery?> {
            return arrayOfNulls(size)
        }
    }
}
