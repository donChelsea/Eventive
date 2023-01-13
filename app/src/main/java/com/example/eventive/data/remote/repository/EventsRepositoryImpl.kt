package com.example.eventive.data.remote.repository

import com.example.eventive.data.remote.SeatGeekApi
import com.example.eventive.data.remote.dtos.mapper.toDomain
import com.example.eventive.domain.models.Event
import com.example.eventive.domain.repository.EventsRepository
import com.example.eventive.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRepositoryImpl @Inject constructor(
    private val api: SeatGeekApi,
) : EventsRepository {

    override suspend fun getEvents(): Flow<Resource<List<Event>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val events = api.getEvents().events
        with(events) {
            emit(Resource.Success(data = map { it.toDomain() }))
        }
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)

}