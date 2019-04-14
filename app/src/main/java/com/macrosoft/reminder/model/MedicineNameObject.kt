package com.macrosoft.reminder.model

import com.macrosoft.reminder.data.HasType
import com.macrosoft.reminder.data.Holder

class MedicineNameObject(val name: String) : HasType {
    override fun getType(): Int {
        return Holder.NESTED.type
    }
}