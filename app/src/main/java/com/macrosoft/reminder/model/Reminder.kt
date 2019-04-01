package com.macrosoft.reminder.model

import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.OffsetDateTime

/**
 * A data class that holds all the persistent data needed for reminders
 *
 * @property ringtone | Stores the source of the preferred ringtone
 * @property dosage | Dosage for a given medicine for the reminder
 * @property frequency | How often the reminder should fire (medicine be taken)
 * @property startDate | Reminder start time
 * @property endDate | Reminder end time
 * @property timesToTake | List of DateTimes when the reminder fires (medicine be taken)
 *
 */

data class Reminder(
    private val ringtone: String,
    private val dosage: String,
    private val frequency: String,
    private val startDate: OffsetDateTime,
    private val endDate: OffsetDateTime,
    private val timesToTake: List<MedicineTime>
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}
