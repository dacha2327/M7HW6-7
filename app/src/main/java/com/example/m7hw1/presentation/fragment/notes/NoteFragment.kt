package com.example.m7hw1.presentation.fragment.notes

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.m7hw1.R
import com.example.m7hw1.databinding.FragmentNoteBinding
import com.example.m7hw1.presentation.base.BaseFragment
import com.example.m7hw1.presentation.fragment.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteFragment : BaseFragment(R.layout.fragment_note) {

    private val viewModel by viewModels<NoteViewModel>()
    private val noteAdapter by lazy { NotesAdapter() }
    private val binding by viewBinding(FragmentNoteBinding::bind)

    override fun initialize() {
        setupNoteRecycler()
    }

    override fun setupListeners() {
        binding.fub.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_editFragment)
        }
    }

    override fun setupRequests() {
        viewModel.getNotes()
    }

    override fun setupSubscribers() {

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getNoteState.collect {
                    when(it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext() , it.message , Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            binding.pbNote.isVisible = true
                        }
                        is UIState.Success -> {
                            binding.pbNote.isVisible = false
                            noteAdapter.submitList(it)
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

            onSuccess = {
                binding.pbNote.isVisible = false
            }
        )

    }

    private fun setupNoteRecycler() = with(binding.recyclerView) {
        adapter = noteAdapter
        layoutManager = LinearLayoutManager(
            requireContext() ,
            LinearLayoutManager.VERTICAL ,
            false
        )
    }

    companion object {
        const val ADD_NOTE = "note"
    }
}