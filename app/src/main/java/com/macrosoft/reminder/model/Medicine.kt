package com.macrosoft.reminder.model

import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * A data class representing a certain type of Medicine
 *
 * @property name | Name of the medicine
 * @property description | Description for the medicine
 *
 */

data class Medicine(
    private var name: String,
    private var description: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}

