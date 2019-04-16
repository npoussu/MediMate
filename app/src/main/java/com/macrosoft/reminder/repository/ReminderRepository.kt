package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.ReminderDAO
import com.macrosoft.reminder.model.Reminder

class ReminderRepository(reminderDAO: ReminderDAO) {
    private val reminderDAOImpl: ReminderDAO = reminderDAO

    fun getRedminderByID(id: Int): LiveData<Reminder> {
        return reminderDAOImpl.getReminderByID(id)
    }

    fun getReminderByUserID(user_id: Int): LiveData<Array<Reminder>> {
        return reminderDAOImpl.getReminderByUserID(user_id)
    }

    fun deleteReminder(reminder: Reminder) {
        return reminderDAOImpl.delete(reminder)
    }

    fun insertReminder(reminder: Reminder) {
        return reminderDAOImpl.insert(reminder)
    }

    fun updateReminder(reminder: Reminder) {
        return reminderDAOImpl.update(reminder)
    }
}