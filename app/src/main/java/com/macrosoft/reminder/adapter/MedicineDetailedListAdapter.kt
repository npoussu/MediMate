package com.macrosoft.reminder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.data.MedicineDetails
import com.macrosoft.reminder.data.MedicineDetailsList

/**
 * Adapter holding data for the list of CardViews showing various medicine to be taken and when
 *
 * This is used at ViewMedicineDetailsFragment
 *
 * @param detailedlist Holds a MedicineDetailsList object which wraps all the details needed for the cards
 *                     such as medicine name, time, amount of pills etc.
 */
class MedicineDetailedListAdapter : RecyclerView.Adapter<MedicineDetailedListAdapter.ViewHolder>() {

    private lateinit var listener: OnItemClickListener
    private lateinit var detailedList: MedicineDetailsList

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = detailedList.items[position]
        holder.medicineTime!!.text = item.time.substring(0,5)
        holder.medicineName!!.text = item.medicine_name
        holder.pillAmount!!.text = item.dosage
        holder.requirementsText!!.text = item.description
    }

    override fun getItemCount() = detailedList.items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medicine_item, parent, false)
        return ViewHolder(view)
    }

    // Set the list of MedicineDetailsList objects and refresh the adapter
    fun setDetailedList(detailedList: MedicineDetailsList) {
        this.detailedList = detailedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val medicineName = itemView.findViewById<TextView?>(R.id.medName)
        val medicineTime = itemView.findViewById<TextView?>(R.id.medicineListTime)
        val pillAmount = itemView.findViewById<TextView?>(R.id.pillAmount)
        val requirementsText = itemView.findViewById<TextView?>(R.id.requirementsText)

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(pos: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun getMedicineDetailsListAt(pos: Int): MedicineDetails {
        return detailedList.items[pos]
    }
}