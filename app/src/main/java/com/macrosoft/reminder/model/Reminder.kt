package com.macrosoft.reminder.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "reminders",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = MedicineData::class,
            parentColumns = ["id"],
            childColumns = ["medicine_id"],
            onDelete = CASCADE
        )],
    indices = [Index(value = ["medicine_id", "user_id"])]
)
data class Reminder(
    @ColumnInfo(name = "user_id")
    var userID: Int,

    @ColumnInfo(name = "medicine_id")
    var medicineID: Int,

    @ColumnInfo(name = "frequency")
    var frequency: String,

    @ColumnInfo(name = "ringtone")
    var ringtone: String?,

    @ColumnInfo(name = "dosage")
    var dosage: String,

    @ColumnInfo(name = "medicine_checker")
    var medicineChecker: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

