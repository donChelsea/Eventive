package com.example.eventive.ui.events

import com.example.eventive.domain.models.Event

sealed class UiEvent

sealed class EventsUiEvent {
    data class UpdateState(val event: Event): UiEvent()
}