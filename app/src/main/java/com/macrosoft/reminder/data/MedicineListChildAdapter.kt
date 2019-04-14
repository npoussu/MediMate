package com.macrosoft.reminder.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.BR
import com.macrosoft.reminder.databinding.MedicineListItemNestedBinding
import com.macrosoft.reminder.model.MedicineNameObject
import kotlin.properties.Delegates


class MedicineListChildAdapter(private val parentPosition: Int) :
    RecyclerView.Adapter<MedicineListChildAdapter.ViewHolder>() {

    private var dataList = emptyList<MedicineNameObject>()

    fun setData(dataList: List<MedicineNameObject>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MedicineListItemNestedBinding.inflate(inflater)
        return ViewHolder(binding, parentPosition)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], getItemViewType(position), nestedElementPosition = position)
    }

    inner class ViewHolder(val binding: ViewDataBinding, private val parentPosition: Int) :
        RecyclerView.ViewHolder(binding.root) {

        private var nestedElementPosition: Int by Delegates.notNull()

        fun bind(item: MedicineNameObject, nestedItemViewType: Int, nestedElementPosition: Int) {
            this.nestedElementPosition = nestedElementPosition
            when (1) {
                1 -> {
                    (binding as MedicineListItemNestedBinding).setVariable(BR.item, item)
                    binding.executePendingBindings()
                }
            }
        }
    }

}
