package com.example.eventive.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class EventDto(
    val type: String,
    val id: Int,
    @SerializedName("datetime_local")
    val date: String,
    val title: String,
    val venue: VenueDto,
    val performers: List<PerformerDto>,
)
