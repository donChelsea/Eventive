package com.example.eventive.ui.event

import androidx.lifecycle.ViewModel
import com.example.eventive.domain.models.Event
import com.example.eventive.ui.events.EventsUiEvent
import com.example.eventive.ui.events.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class EventViewModel : ViewModel() {

    private val _state: MutableStateFlow<EventsUiState> = MutableStateFlow(EventsUiState())
    val state: StateFlow<EventsUiState> = _state

    fun postEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is EventsUiEvent.UpdateState -> _state.update { it.copy(event = uiEvent.event) }
        }

    }
}

data class EventsUiState(
    val event: Event? = null
)