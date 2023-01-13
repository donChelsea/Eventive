package com.example.eventive.domain.models

data class Venue(
    val id: Int,
    val name: String,
    val location: String,
    val hasUpcomingEvents: Boolean,
)
