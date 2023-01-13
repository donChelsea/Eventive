package com.example.eventive.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class PerformerDto(
    val name: String,
    val id: Int,
    val image: String,
    @SerializedName("has_upcoming_events")
    val hasUpcomingEvents: Boolean,
)