package com.macrosoft.reminder.data

/**
 * Wrapper for MedicineDetails. Also holds an Database ID for a group of medicine to be taken
 * at a same time
 *
 * @param ID Database ID for a reminder
 * @param items List of MedicineDetails
 *
 */
data class MedicineDetailsList(
    var ID: Int,
    var items: ArrayList<MedicineDetails>
)