package com.developersbreach.firestoreandroid

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class Sports : Parcelable {

    var title: String? = null
    var originated: String? = null

    constructor()

    private constructor(parcel: Parcel) {
        title = parcel.readString()
        originated = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeString(originated)
    }

    companion object CREATOR : Parcelable.Creator<Sports> {
        override fun createFromParcel(parcel: Parcel): Sports {
            return Sports(parcel)
        }

        override fun newArray(size: Int): Array<Sports?> {
            return arrayOfNulls(size)
        }
    }
}