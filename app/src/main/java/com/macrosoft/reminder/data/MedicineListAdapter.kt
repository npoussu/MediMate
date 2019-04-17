package com.macrosoft.reminder.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.data.MedicineListAdapter.ViewHolder
import com.macrosoft.reminder.model.MedicineListObject

/**
 * MedicineListAdapter: Holds the data for the outer portion of the Medicine list layout (time)
 * Also has a reference to it's nested RecyclerView MedicineListChildAdapter and sets the data inside the nested adapter
 */

class MedicineListAdapter(var context: Context, var medicineData: List<MedicineListObject>) :
    RecyclerView.Adapter<ViewHolder>() {

    private var recycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medicine_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = medicineData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = medicineData[position]
        holder.time?.text = item.time

        // Create the adapter for the nested RecyclerView and set the data using a constructor parameter
        val verticalAdapter = MedicineListChildAdapter(context, item.medicine)
        holder.nestedRecyclerView?.adapter = verticalAdapter
        holder.nestedRecyclerView?.setRecycledViewPool(recycledViewPool)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val verticalManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val time = itemView.findViewById<TextView?>(R.id.medicineListTime)
        val nestedRecyclerView = itemView.findViewById<RecyclerView?>(R.id.medicineItem_rv_nested)

        init {
            nestedRecyclerView!!.isNestedScrollingEnabled = false
            nestedRecyclerView.layoutManager = verticalManager
        }
    }
}
