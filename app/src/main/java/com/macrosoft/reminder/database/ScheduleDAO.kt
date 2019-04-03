package com.macrosoft.reminder.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.macrosoft.reminder.model.Schedule


@Dao
interface ScheduleDAO {
    @Query("SELECT * FROM schedules where :id = user_id")
    fun get(id: Int): Schedule

    @Insert
    fun insert(vararg s: Schedule)

    @Delete
    fun delete(s: Schedule)
}