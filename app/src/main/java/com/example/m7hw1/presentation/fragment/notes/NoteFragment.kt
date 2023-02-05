package com.example.m7hw1.presentation.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.m7hw1.R
import com.example.m7hw1.databinding.FragmentNoteBinding
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.presentation.fragment.UIState
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch


class NoteFragment : Fragment() {

    private val viewModel : NoteViewModel by viewModels()
    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotes()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getNoteState.collect {
                    when(it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext() , it.message , Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                           binding.fub
                        }
                        is UIState.Success -> {
                            binding.recyclerView.adapter  = adapter
                        }
                    }
                }
            }
        }


    }

}