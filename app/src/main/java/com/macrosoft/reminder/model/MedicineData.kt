package com.macrosoft.reminder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "medicine_data",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        )]
)
data class MedicineData(
    @PrimaryKey
    @ColumnInfo(name = "user_id") var userID: Int,
    @ColumnInfo(name = "medicine_name") var medicineName: String,
    @ColumnInfo(name = "description") var description: String?
)