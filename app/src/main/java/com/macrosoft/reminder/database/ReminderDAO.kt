package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.model.Reminder



@Dao
interface ReminderDAO :BaseDao<Reminder> {
    @Query("SELECT * FROM reminders where :user_id = user_id")
    fun getByUserID(user_id: Int): LiveData<Reminder>

}