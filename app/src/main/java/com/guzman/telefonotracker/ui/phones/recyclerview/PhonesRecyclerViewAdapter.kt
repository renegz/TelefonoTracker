package com.guzman.telefonotracker.ui.phones.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guzman.telefonotracker.data.models.TelefonoModel
import com.guzman.telefonotracker.databinding.PhoneItemBinding

class PhonesRecyclerViewAdapter(private val OnItemSelected: (TelefonoModel) -> Unit) :
    RecyclerView.Adapter<PhonesRecyclerViewHolder>() {

    private val telefonos = ArrayList<TelefonoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesRecyclerViewHolder {
        val binding = PhoneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhonesRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = telefonos.size

    override fun onBindViewHolder(holder: PhonesRecyclerViewHolder, position: Int) {
        val phone = telefonos[position]
        holder.bind(phone, OnItemSelected)
    }

    fun setData(phonesList: List<TelefonoModel>){
        telefonos.clear()
        telefonos.addAll(phonesList)
    }
}