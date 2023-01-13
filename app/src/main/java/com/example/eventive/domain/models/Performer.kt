package com.example.eventive.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Performer(
    val name: String,
    val id: Int,
    val image: String,
    val hasUpcomingEvents: Boolean,
) : Parcelable