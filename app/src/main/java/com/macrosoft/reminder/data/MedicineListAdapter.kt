package com.macrosoft.reminder.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.databinding.MedicineListItemBinding
import com.macrosoft.reminder.model.MedicineListData

class MedicineListAdapter(private val medicineList: List<MedicineListData>) :
    RecyclerView.Adapter<MedicineListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MedicineListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = medicineList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(medicineList[position])

    inner class ViewHolder(val binding: MedicineListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MedicineListData) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}