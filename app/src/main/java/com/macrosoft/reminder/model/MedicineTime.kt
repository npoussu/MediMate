package com.macrosoft.reminder.model

import java.time.OffsetDateTime

/**
 * A wrapper for OffsetDateTime, adds a boolean flag isTaken that can be used to
 * mark the Medicine taken at a certain time (isTaken = true)
 *
 * @property timeToTake | DateTime, when medicine should be taken
 * @property isTaken | Boolean, set to true when medicine is taken
 */

data class MedicineTime(
    private val timeToTake: OffsetDateTime,
    private val isTaken: Boolean
)
