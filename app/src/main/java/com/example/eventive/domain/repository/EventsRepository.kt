package com.example.eventive.domain.repository

import com.example.eventive.domain.models.Event
import com.example.eventive.utils.Resource
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun getEvents(): Flow<Resource<List<Event>>>
}