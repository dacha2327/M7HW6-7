package com.example.m7hw1.presentation.fragment.notes

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.m7hw1.R
import com.example.m7hw1.databinding.FragmentNoteBinding
import com.example.m7hw1.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

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

        viewModel.getNoteState.collectState(
            onLoading = {
                binding.pbNote.isVisible = true
            },

            onError = {
                Toast.makeText(requireContext() , it , Toast.LENGTH_SHORT).show()
                binding.pbNote.isVisible = false
            },

            onSuccess = {
                noteAdapter.submitList(it)
                binding.pbNote.isVisible = false
            }
        )

        viewModel.deleteNoteState.collectState(
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

}