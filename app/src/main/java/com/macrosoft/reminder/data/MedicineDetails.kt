package com.macrosoft.reminder.data

/**
 * Data class holding all the data needed to display for the CardViews showing details
 * about a medicine reminder
 *
 * @param name Name of the medicine
 * @param time Time for medicine to be taken
 * @param dosage Medicine dosage
 * @param requirements Any requirements for taking the medicine (e.g. consume with water)
 *
 */
data class MedicineDetails(
    val id: Int,
    val medicine_name: String,
    var time: String,
    val dosage: String,
    val description: String
)
