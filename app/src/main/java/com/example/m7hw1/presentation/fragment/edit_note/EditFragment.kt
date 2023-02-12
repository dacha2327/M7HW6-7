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
import com.example.m7hw1.R
import com.example.m7hw1.databinding.FragmentEditBinding
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.presentation.base.BaseFragment
import com.example.m7hw1.presentation.fragment.UIState
import kotlinx.coroutines.launch

class EditFragment : BaseFragment() {

    private val viewModel by viewModels<EditViewModel>()
    private lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(layoutInflater  , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.createNotes(Note(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString(),
            createdAd = System.currentTimeMillis()
        ))

        viewModel.createNoteState.collectState<UIState<Unit>>(
            onError = {
                Toast.makeText(requireContext() , it  , Toast.LENGTH_SHORT).show()
            },
            onLoading = {},

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