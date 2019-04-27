package com.macrosoft.reminder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Time

@Entity(
    tableName = "schedules",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        )],
    indices = [androidx.room.Index(value = ["user_id"])]
)
data class Schedule(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "user_id")
    var userID: Int,

    @ColumnInfo(name = "start_date")
    var startDate: Date,

    @ColumnInfo(name = "end_date")
    var endDate: Date?,

    @ColumnInfo(name = "indefinite_end_date")
    var indefiniteEndDate: Boolean,

    @ColumnInfo(name = "time")
    var time: ArrayList<Time>
)