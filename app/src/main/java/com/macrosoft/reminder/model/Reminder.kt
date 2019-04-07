package com.macrosoft.reminder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "reminders",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        )]
)
data class Reminder(
    @PrimaryKey
    @ColumnInfo(name = "user_id") var userID: Int,
    @ColumnInfo(name = "frequency") var frequency: String,
    @ColumnInfo(name = "ringtone") var ringtone: String?,
    @ColumnInfo(name = "dosage") var dosage: Int,
    @ColumnInfo(name = "medicine_checker") var medicineChecker: Int?
)