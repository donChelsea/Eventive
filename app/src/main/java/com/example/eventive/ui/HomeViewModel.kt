package com.example.eventive.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventive.domain.models.Event
import com.example.eventive.domain.repository.EventsRepository
import com.example.eventive.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: EventsRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<EventsUiState> = MutableStateFlow(EventsUiState())
    val state: StateFlow<EventsUiState>
        get() = _state

    init {
        viewModelScope.launch {
            repository.getEvents().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { list ->
                            _state.update { it.copy(events = list) }
                        }
                    }
                    is Resource.Loading -> println(result.isLoading)
                    is Resource.Error -> println(result.message.toString())
                }
            }
        }
    }
}

data class EventsUiState(
    val events: List<Event> = emptyList()
)