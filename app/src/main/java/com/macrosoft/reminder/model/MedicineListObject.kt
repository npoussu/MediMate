package com.macrosoft.reminder.model

/**
 * MedicineListObject: Wrapper for time to take medicine & list of medicines
 */
data class MedicineListObject(
    val time: String,
    val medicine: List<String>
)