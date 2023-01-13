package com.example.eventive.data.remote

import com.example.eventive.data.remote.dtos.EventDto
import com.example.eventive.data.remote.dtos.EventsListResultDto
import com.example.eventive.utils.CLIENT_ID
import com.example.eventive.utils.CLIENT_SECRET
import com.example.eventive.utils.DEFAULT_STATE
import retrofit2.http.GET
import retrofit2.http.Query

interface SeatGeekApi {

    @GET("events")
    suspend fun getEvents(
        @Query("client_id") clientId: String = CLIENT_ID,
        @Query("client_secret") clientSecret: String = CLIENT_SECRET,
        @Query("venue.state") state: String = DEFAULT_STATE,
    ): EventsListResultDto<EventDto>
}