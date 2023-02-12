package com.example.m7hw1.presentation.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.m7hw1.databinding.FragmentNoteBinding
import com.example.m7hw1.presentation.base.BaseFragment
import com.example.m7hw1.presentation.fragment.UIState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class NoteFragment : BaseFragment() {

    private val viewModel by viewModels<NoteViewModel>()
    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter : NotesAdapter

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
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                        }
                    }
                }
            }
        }

        viewModel.deleteNoteState.collectState<UIState<Unit>>(
            onLoading = {
                binding.pbNote.isVisible = true
            },

            onError = {
                Toast.makeText(requireContext() , it , Toast.LENGTH_SHORT).show()
                binding.pbNote.isVisible = false
            },

            onSuccess = {}
        )

    }



}