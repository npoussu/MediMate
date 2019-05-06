package com.macrosoft.reminder.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.adapter.MedicineListAdapter.ViewHolder
import com.macrosoft.reminder.data.MedicineListObject
import com.macrosoft.reminder.model.MedicineSchedule
import java.sql.Time


/**
 * An adapter holding data for the Main Screen of the app displaying a card of reminder times for medicine to be taken
 *
 * @param medicineData Holds the reminder times
 */

class MedicineListAdapter :
    RecyclerView.Adapter<ViewHolder>() {

    private lateinit var listenerImpl: OnItemClickListener
    private var medicineData: ArrayList<MedicineListObject> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medicine_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = medicineData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = medicineData[position]
        holder.time?.text = item.time.toString().subSequence(0,5)
        holder.medicineNames?.text = item.medicineNames
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time = itemView.findViewById<TextView?>(R.id.medicineListTime)
        val medicineNames = itemView.findViewById<TextView?>(R.id.medicineNameList)

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

    private fun parseTime(medicineScheduleArray: Array<MedicineSchedule>): ArrayList<MedicineListObject> {
        val medicineList = arrayListOf<MedicineListObject>()
        val timesArrayList = arrayListOf<Time>()

        // Get all Times and put in timesArrayList
        for (medicineSchedule in medicineScheduleArray) {
            for (time in medicineSchedule.time) {
                if(!timesArrayList.contains(time)) {
                    timesArrayList.add(time)
                }
            }
        }

        for(timeObject in timesArrayList) {
            var time = timeObject
            var medicineNames = ""
            var medicineIDs: ArrayList<Int> = arrayListOf()


            for(medicineSchedule in medicineScheduleArray) {
                if(medicineSchedule.time.contains(timeObject)) {
                    medicineNames += medicineSchedule.medicineName + "\n"
                    medicineIDs.add(medicineSchedule.medicineID)
                }
            }

            medicineList.add(MedicineListObject(medicineIDs, time, medicineNames))
        }
        return medicineList
    }

    fun setMedicineList(medicineScheduleArray: Array<MedicineSchedule>) {
        medicineData = parseTime(medicineScheduleArray)
        notifyDataSetChanged()
    }

    fun getMedicineAt(pos: Int): MedicineListObject {
        return medicineData[pos]
    }
}