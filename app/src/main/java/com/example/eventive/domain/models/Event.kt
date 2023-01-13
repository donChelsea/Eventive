package com.example.eventive.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val type: String,
    val id: Int,
    val date: String,
    val title: String,
    val venue: Venue,
    val performers: List<Performer>,
) : Parcelable