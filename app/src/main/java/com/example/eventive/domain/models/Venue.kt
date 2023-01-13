package com.example.eventive.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue(
    val id: Int,
    val name: String,
    val location: String,
    val hasUpcomingEvents: Boolean,
) : Parcelable
