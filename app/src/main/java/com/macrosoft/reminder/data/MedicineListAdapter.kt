package com.macrosoft.reminder.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.data.MedicineListAdapter.ViewHolder
import com.macrosoft.reminder.model.MedicineListObject

/**
 * An adapter holding data for the Main Screen of the app displaying a card of reminder times for medicine to be taken
 *
 * @param medicineData Holds the reminder times
 */

class MedicineListAdapter :
    RecyclerView.Adapter<ViewHolder>() {

    private lateinit var listenerImpl: OnItemClickListener
    private var medicineData: List<MedicineListObject> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medicine_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = medicineData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = medicineData[position]
        holder.time?.text = item.time
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time = itemView.findViewById<TextView?>(R.id.medicineListTime)

        init {
            itemView.setOnClickListener {
                listenerImpl.onClick(adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(pos: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        listenerImpl = listener
    }

    fun setMedicineList(medicineListObject: List<MedicineListObject>) {
        medicineData = medicineListObject
        notifyDataSetChanged()
    }

    fun getMedicineAt(pos: Int): MedicineListObject {
        return medicineData[pos]
    }
}
