package com.macrosoft.reminder.data

import java.sql.Time

/**
 * MedicineListObject: Wrapper for time to take medicine & list of medicines
 */
class MedicineListObject(
    val medicineIDs: ArrayList<Int>,
    val time: Time,
    val medicineNames: String
)