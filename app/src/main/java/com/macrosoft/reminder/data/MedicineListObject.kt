package com.macrosoft.reminder.data

/**
 * MedicineListObject: Wrapper for time to take medicine & list of medicines
 */
class MedicineListObject(
    val medicineIDs: ArrayList<Int>,
    val time: String,
    val medicineNames: String
)