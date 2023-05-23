package com.guzman.telefonotracker.ui.phones

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.guzman.telefonotracker.R
import com.guzman.telefonotracker.data.models.TelefonoModel
import com.guzman.telefonotracker.databinding.FragmentPhonesBinding
import com.guzman.telefonotracker.ui.phones.recyclerview.PhonesRecyclerViewAdapter
import com.guzman.telefonotracker.ui.viewmodel.PhoneViewModel

class PhonesFragment : Fragment() {

    private lateinit var binding: FragmentPhonesBinding
    private lateinit var adapter: PhonesRecyclerViewAdapter

    val viewModel: PhoneViewModel by activityViewModels {
        PhoneViewModel.Factory
    }

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
        setRecyclerView(view)
    }

    private fun addListeners(){
        binding.NavToNewPhoneFAB.setOnClickListener {
            viewModel.clearData()
            findNavController().navigate(R.id.action_phonesFragment_to_newPhoneFragment)
        }
    }

    private fun showSelectedItem(phone: TelefonoModel){
        viewModel.SetSelectedPhone(phone)
        findNavController().navigate(R.id.action_phonesFragment_to_phoneDetailFragment)
    }

    private fun displayPhones(){
        adapter.setData(viewModel.getPhones())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view:View){
        binding.phonesRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PhonesRecyclerViewAdapter {
            showSelectedItem(it)
        }

        binding.phonesRecyclerView.adapter = adapter
        displayPhones()
    }


}