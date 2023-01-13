package com.example.eventive.domain.models

data class Event(
    val type: String,
    val id: Int,
    val date: String,
    val title: String,
    val venue: Venue,
    val performers: List<Performer>,
)