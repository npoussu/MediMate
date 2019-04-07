package com.macrosoft.reminder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "schedules",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        )]
)
data class Schedule(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "user_id")
    var userID: Int,

    @ColumnInfo(name = "start_date")
    var startDate: Long,

    @ColumnInfo(name = "end_date")
    var endDate: Long?,

    @ColumnInfo(name = "indefinite_end_date")
    var indefiniteEndDate: Boolean,

    @ColumnInfo(name = "time")
    var time: String?
)