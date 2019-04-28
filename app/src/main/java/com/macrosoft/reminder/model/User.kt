package com.macrosoft.reminder.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "password")
    var userPassword: String,

    @ColumnInfo(name = "display_name")
    var displayName: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

