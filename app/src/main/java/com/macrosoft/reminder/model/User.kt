package com.macrosoft.reminder.model

import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * A data class that represents a User and it's properties
 *
 * @property username
 * @property displayName | Name that is displayed to the user
 * @property password
 */

data class User(
    private val username: String,
    private var displayName: String,
    private val password: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}
