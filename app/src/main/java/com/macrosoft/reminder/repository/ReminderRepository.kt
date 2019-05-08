package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.ReminderDAO
import com.macrosoft.reminder.model.Reminder

class ReminderRepository(reminderDAO: ReminderDAO) {
    private val reminderDAOImpl: ReminderDAO = reminderDAO

    fun deleteReminderByMedID(id: Int) {
        return reminderDAOImpl.deleteReminderByMedID(id)
    }

    fun insertReminder(reminder: Reminder): Long {
        return reminderDAOImpl.insert(reminder)
    }

    fun updateReminderByMedicineID(id: Int, dosage: String){
        return reminderDAOImpl.updateReminderByMedicineID(id, dosage)
    }
}