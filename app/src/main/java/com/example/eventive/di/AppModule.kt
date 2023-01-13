package com.example.eventive.di

import com.example.eventive.data.remote.SeatGeekApi
import com.example.eventive.data.remote.repository.EventsRepositoryImpl
import com.example.eventive.domain.repository.EventsRepository
import com.example.eventive.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object AppModule {

    @Provides
    @Singleton
    fun provideSeatGeekApi(): SeatGeekApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SeatGeekApi::class.java)

    @Provides
    @Singleton
    fun provideEventsRepository(api: SeatGeekApi): EventsRepository = EventsRepositoryImpl(api)

}