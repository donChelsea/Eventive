package com.example.eventive.domain.models

data class Performer(
    val name: String,
    val id: Int,
    val image: String,
    val hasUpcomingEvents: Boolean,
)