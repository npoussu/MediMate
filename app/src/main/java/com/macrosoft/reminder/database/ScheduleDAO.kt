package com.macrosoft.reminder.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.macrosoft.reminder.model.Schedule


@Dao
interface ScheduleDAO {
    @Query("SELECT * FROM schedules where :user_id = user_id")
    fun getByUserID(user_id: Int): Schedule

    @Insert
    fun insert(schedule: Schedule)

    @Delete
    fun delete(schedule: Schedule)
}