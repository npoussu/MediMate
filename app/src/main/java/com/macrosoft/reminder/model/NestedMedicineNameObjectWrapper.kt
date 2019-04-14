package com.macrosoft.reminder.model

import com.macrosoft.reminder.data.HasType
import com.macrosoft.reminder.data.Holder

class NestedMedicineNameObjectWrapper(val nestedMedicineNameObjectList: List<MedicineNameObject>) : HasType {
    override fun getType(): Int {
        return Holder.NESTED.type
    }
}