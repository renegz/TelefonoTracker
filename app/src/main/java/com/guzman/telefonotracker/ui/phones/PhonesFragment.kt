package com.guzman.telefonotracker.ui.phones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.guzman.telefonotracker.R
import com.guzman.telefonotracker.databinding.FragmentPhonesBinding

class PhonesFragment : Fragment() {

    private lateinit var binding: FragmentPhonesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhonesBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addListeners()
    }

    private fun addListeners(){
        binding.NavToNewPhoneFAB.setOnClickListener {
            findNavController().navigate(R.id.action_phonesFragment_to_newPhoneFragment)
        }
    }
}