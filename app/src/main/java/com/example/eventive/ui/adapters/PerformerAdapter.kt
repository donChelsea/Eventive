package com.example.eventive.ui.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.eventive.R
import com.example.eventive.databinding.ListItemEventBinding
import com.example.eventive.databinding.ListItemPerformerBinding
import com.example.eventive.domain.models.Event
import com.example.eventive.domain.models.Performer
import com.example.eventive.utils.convertDayAndTime
import com.squareup.picasso.Picasso

class PerformerAdapter(private val performers: List<Performer>, private val clickListener: (Int) -> Unit) : Adapter<PerformerAdapter.PerformerViewHolder>() {

    inner class PerformerViewHolder(private val binding: ListItemPerformerBinding) : ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(performer: Performer) {
            binding.apply {
                name.text = performer.name
                if (performer.hasUpcomingEvents) seeAllShows.visibility = View.VISIBLE
                seeAllShows.setOnClickListener {
                    clickListener(performer.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformerViewHolder {
        val view = ListItemPerformerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PerformerViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PerformerViewHolder, position: Int) = holder.bind(performers[position])

    override fun getItemCount() = performers.size
}