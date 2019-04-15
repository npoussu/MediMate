package com.macrosoft.reminder.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R


/**
 * MedicineListChildAdapter: Nested RecyclerView inside MedicineListAdapter
 * Holds a list of medicine.
 */
class MedicineListChildAdapter(private var context: Context, private var items: List<String>) :
    RecyclerView.Adapter<MedicineListChildAdapter.MedicineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        return MedicineViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.medicine_list_item_nested,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.name?.text = items[position]
    }

    inner class MedicineViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView?>(R.id.medicineNameNested)
    }

}
