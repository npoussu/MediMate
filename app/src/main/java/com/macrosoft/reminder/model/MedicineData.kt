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

    @ColumnInfo(name = "user_id")
    var userID: Int,

    @ColumnInfo(name = "medicine_name")
    var medicineName: String,

    @ColumnInfo(name = "description")
    var description: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
