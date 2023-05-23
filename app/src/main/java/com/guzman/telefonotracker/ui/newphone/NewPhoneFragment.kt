package com.guzman.telefonotracker.ui.newphone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.guzman.telefonotracker.databinding.FragmentNewPhoneBinding
import com.guzman.telefonotracker.ui.viewmodel.PhoneViewModel

class NewPhoneFragment : Fragment() {

    private lateinit var binding: FragmentNewPhoneBinding

    private val viewModel: PhoneViewModel by activityViewModels {
        PhoneViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        onCreatePhone()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun onCreatePhone(){
        binding.actionAddPhone.setOnClickListener {
            viewModel.createPhone()
            findNavController().popBackStack()
        }
    }
}