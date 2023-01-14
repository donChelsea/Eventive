package com.example.eventive.ui.event

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.eventive.databinding.FragmentEventBinding
import com.example.eventive.ui.adapters.PerformerAdapter
import com.example.eventive.ui.events.EventsUiEvent
import com.example.eventive.utils.convertDayAndTime
import com.squareup.picasso.Picasso

class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventBinding
    private val viewModel by viewModels<EventViewModel>()
    private val args: EventFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentEventBinding.inflate(layoutInflater)
        viewModel.postEvent(EventsUiEvent.UpdateState(args.event))
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                binding.apply {
                    state.event?.let { event ->
                        val eventImage = event.performers[0].image
                        Picasso.get().load(eventImage).into(image)
                        type.text = event.type
                        title.text = event.title
                        dateText.text = convertDayAndTime(event.date).first
                        venue.text = event.venue.name
                        address.text = event.venue.address
                        cityText.text = event.venue.location
                        recyclerview.adapter = PerformerAdapter(event.performers) {id -> seeMoreShows(id)}
                    }

                }
            }
        }

    }

    private fun seeMoreShows(id: Int) {
        println("performer id: $id")
    }
}