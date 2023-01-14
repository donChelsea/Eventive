package com.example.eventive.ui.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.eventive.R
import com.example.eventive.databinding.ListItemEventBinding
import com.example.eventive.domain.models.Event
import com.example.eventive.utils.convertDayAndTime
import com.squareup.picasso.Picasso

class EventAdapter(private val events: List<Event>, private val clickListener: (Event) -> Unit) : Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(private val binding: ListItemEventBinding) : ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(event: Event) {
            val image = event.performers[0].image
            val dayAndTime = convertDayAndTime(event.date)

            binding.apply {
                Picasso.get().load(image).into(eventImage)
                eventName.text = event.title
                month.text = dayAndTime.first.substring(0..2)
                day.text = dayAndTime.first.substring(4..5)
                timeAndLocation.text = itemView.context.getString(R.string.time_and_location, dayAndTime.second, event.venue.location)
                root.setOnClickListener { clickListener(event) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = ListItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.itemView.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.slide_in_anim)
        holder.bind(events[position])
    }

    override fun getItemCount() = events.size
}