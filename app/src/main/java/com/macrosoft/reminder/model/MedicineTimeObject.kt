package com.macrosoft.reminder.model

import com.macrosoft.reminder.data.HasType
import com.macrosoft.reminder.data.Holder

data class MedicineTimeObject(
    val time: String
) : HasType {
    override fun getType(): Int {
        return Holder.PARENT.type
    }
}