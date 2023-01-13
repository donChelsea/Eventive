package com.example.eventive.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.eventive.databinding.FragmentEventBinding
import com.example.eventive.utils.convertDayAndTime

class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventBinding
    private val viewModel by viewModels<EventViewModel>()
    val args: EventFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentEventBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        convertDayAndTime(args.event.date)
    }

}