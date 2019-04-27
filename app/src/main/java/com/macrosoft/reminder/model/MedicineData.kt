package com.macrosoft.reminder.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "medicine_data",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        )],
    indices = [Index(value = ["user_id"])]
)
data class MedicineData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "user_id")
    var userID: Int,

    @ColumnInfo(name = "reminder_id")
    var reminderID: Int,

    @ColumnInfo(name = "schedule_id")
    var scheduleID: Int,

    @ColumnInfo(name = "medicine_name")
    var medicineName: String,

    @ColumnInfo(name = "description")
    var description: String?
)