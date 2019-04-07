package com.macrosoft.reminder.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.macrosoft.reminder.model.Reminder
import com.macrosoft.reminder.model.Schedule


@Dao
interface ReminderDAO {
    @Query("SELECT * FROM reminders where :user_id = user_id")
    fun getByUserID(user_id: Int): Reminder

    @Insert
    fun insert(reminder: Reminder)

    @Delete
    fun delete(reminder: Reminder)
}