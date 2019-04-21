package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.model.Reminder

@Dao
interface ReminderDAO :BaseDao<Reminder> {
    @Query("SELECT * FROM reminders where :reminder_id = id")
    fun getReminderByID(reminder_id: Int): LiveData<Reminder>

    @Query("SELECT * FROM reminders where user_id = :user_id")
    fun getReminderByUserID(user_id: Int): LiveData<Array<Reminder>>

}