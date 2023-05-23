package com.guzman.telefonotracker.ui.phones.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.guzman.telefonotracker.data.models.TelefonoModel
import com.guzman.telefonotracker.databinding.PhoneItemBinding

class PhonesRecyclerViewHolder(private val binding: PhoneItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(phone: TelefonoModel, OnItemSelected: (TelefonoModel) -> Unit){
            binding.tvMarca.text = phone.marca
            binding.tvModelo.text = phone.modelo

            binding.phoneCardView.setOnClickListener {
                OnItemSelected(phone)
            }
        }
}