package com.example.m7hw1.presentation.fragment.edit_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.m7hw1.R
import com.example.m7hw1.databinding.FragmentEditBinding
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.presentation.base.BaseFragment
import com.example.m7hw1.presentation.fragment.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditFragment : BaseFragment(R.layout.fragment_edit) {

    private val viewModel by viewModels<EditViewModel>()
    private val binding by viewBinding(FragmentEditBinding::bind)
    private var note : Note? = null

    override fun initialize() {

    }

    override fun setupListeners() {
        binding.btnSave.setOnClickListener {
            viewModel.createNotes(Note(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString(),
                createdAd = System.currentTimeMillis()
            ))
        }
    }

    override fun setupSubscribers() {
        viewModel.createNoteState.collectState<UIState<Unit>>(
            onLoading = {},

            onError = {
                Toast.makeText(requireContext() , it  , Toast.LENGTH_SHORT).show()
            },

            onSuccess = {
                findNavController().navigateUp()
            }
        )

        viewModel.editNoteState.collectState<UIState<Unit>>(
            onError = {
                Toast.makeText(requireContext() , it  , Toast.LENGTH_SHORT).show()
            },

            onLoading = {},

            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }
}