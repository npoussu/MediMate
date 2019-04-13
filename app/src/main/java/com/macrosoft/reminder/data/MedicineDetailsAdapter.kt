package com.macrosoft.reminder.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.databinding.MedicineItemBinding
import com.macrosoft.reminder.model.MedicineCardItemDetailed

class MedicineDetailsAdapter(private val medicineListDetailed: List<MedicineCardItemDetailed>) :
    RecyclerView.Adapter<MedicineDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MedicineItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = medicineListDetailed.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(medicineListDetailed[position])

    inner class ViewHolder(val binding: MedicineItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MedicineCardItemDetailed) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}