package com.example.eventive.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class VenueDto(
    val id: Int,
    val name: String,
    @SerializedName("display_location")
    val location: String,
    @SerializedName("has_upcoming_events")
    val hasUpcomingEvents: Boolean,
)
