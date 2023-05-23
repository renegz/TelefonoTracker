package com.guzman.telefonotracker.ui.phonedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.guzman.telefonotracker.R
import com.guzman.telefonotracker.databinding.FragmentPhoneDetailBinding
import com.guzman.telefonotracker.ui.viewmodel.PhoneViewModel

class PhoneDetailFragment : Fragment() {

    private val viewModel: PhoneViewModel by activityViewModels {
        PhoneViewModel.Factory
    }

    private lateinit var binding: FragmentPhoneDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhoneDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

}