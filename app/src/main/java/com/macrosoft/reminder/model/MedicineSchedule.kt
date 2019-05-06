package com.macrosoft.reminder.model

import androidx.room.*
import java.sql.Time

data class MedicineSchedule(
    @ColumnInfo(name = "medicine_name")
    var medicineName: String,

    @ColumnInfo(name = "medicine_id")
    var medicineID: Int,

    @ColumnInfo(name = "time")
    var time: ArrayList<Time>
)
