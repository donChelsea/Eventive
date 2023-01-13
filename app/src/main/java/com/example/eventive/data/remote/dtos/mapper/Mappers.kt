package com.example.eventive.data.remote.dtos.mapper

import com.example.eventive.data.remote.dtos.EventDto
import com.example.eventive.data.remote.dtos.PerformerDto
import com.example.eventive.data.remote.dtos.VenueDto
import com.example.eventive.domain.models.Event
import com.example.eventive.domain.models.Performer
import com.example.eventive.domain.models.Venue

fun EventDto.toDomain() = Event(
    type = type,
    id = id,
    date = date,
    title = title,
    venue = venue.toDomain(),
    performers = performers.map { it.toDomain() }
)

fun PerformerDto.toDomain() = Performer(
    name = name,
    id = id,
    image = image,
    hasUpcomingEvents = hasUpcomingEvents
)

fun VenueDto.toDomain() = Venue(
    name = name,
    id = id,
    location = location,
    hasUpcomingEvents = hasUpcomingEvents
)