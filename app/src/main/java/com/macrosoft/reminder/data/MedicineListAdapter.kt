package com.macrosoft.reminder.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.BR
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.MedicineListItemBinding
import com.macrosoft.reminder.databinding.MedicineListVerticalHostBinding
import com.macrosoft.reminder.model.MedicineTimeObject
import com.macrosoft.reminder.model.NestedMedicineNameObjectWrapper
import kotlin.properties.Delegates

class MedicineListAdapter :
    RecyclerView.Adapter<MedicineListAdapter.ViewHolder>() {

    private var listOfMedicineTimeData = listOf<HasType>()

    fun setData(dataList: List<HasType>) {
        listOfMedicineTimeData = emptyList()
        listOfMedicineTimeData = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding: ViewDataBinding? = null

        when (viewType) {
            Holder.PARENT.type -> binding =
                DataBindingUtil.inflate<MedicineListItemBinding>(
                    inflater, R.layout.medicine_list_item, parent, false
                )
            Holder.NESTED.type -> binding = DataBindingUtil.inflate<MedicineListVerticalHostBinding>(
                inflater,
                R.layout.medicine_list_vertical_host,
                parent,
                false
            )
        }
        return ViewHolder(binding!!)
    }

    override fun getItemCount(): Int = listOfMedicineTimeData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfMedicineTimeData[position], getItemViewType(position), position)
    }

    override fun getItemViewType(position: Int): Int {
        return listOfMedicineTimeData[position].getType()
    }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var parentPosition: Int by Delegates.notNull()

        fun bind(item: HasType, viewType: Int, parentPosition: Int) {
            this.parentPosition = parentPosition

            when (viewType) {
                Holder.PARENT.type -> {
                    with(binding) {
                        setVariable(BR.item, item as MedicineTimeObject)
                        executePendingBindings()
                    }
                }
                Holder.NESTED.type -> {
                    val nestedAdapter = MedicineListChildAdapter(parentPosition).apply {
                        setData(dataList = (item as NestedMedicineNameObjectWrapper).nestedMedicineNameObjectList)
                    }
                    with(binding) {
                        setVariable(BR.adapter, nestedAdapter)
                        executePendingBindings()
                    }
                }
            }
        }
    }
}