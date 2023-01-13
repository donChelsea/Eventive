package com.example.eventive.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.eventive.databinding.ListItemEventBinding
import com.example.eventive.domain.models.Event
import com.squareup.picasso.Picasso

class EventAdapter(private val events: List<Event>, private val clickListener: (Event) -> Unit) : Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(private val binding: ListItemEventBinding) : ViewHolder(binding.root) {
        fun bind(event: Event) {
            val image = event.performers[0].image

            binding.apply {
                Picasso.get().load(image).into(eventImage)
                eventName.text = event.title
                root.setOnClickListener { clickListener(event) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = ListItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(events[position])

    override fun getItemCount() = events.size
}