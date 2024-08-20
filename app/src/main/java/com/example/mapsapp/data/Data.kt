package com.example.mapsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val bantuan: String,
    val korban: String,
    val lokasi: String,
    val tahun: String
) : Parcelable

