package com.example.doh.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.doh.databinding.AddEntityDialogFragmentBinding
import com.google.android.material.datepicker.MaterialDatePicker

class AddEntityDialogFragment :DialogFragment() {

    private lateinit var binding: AddEntityDialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddEntityDialogFragmentBinding.inflate(inflater)

        binding.finStartDateInputlayout.setOnClickListener {
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Start Date")
        }
        return binding.root
    }
}