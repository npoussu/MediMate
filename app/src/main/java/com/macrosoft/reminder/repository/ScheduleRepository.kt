package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.ScheduleDAO
import com.macrosoft.reminder.model.Schedule

class ScheduleRepository(scheduleDAO: ScheduleDAO) {
    private val scheduleDAOImpl: ScheduleDAO = scheduleDAO

    fun getScheduleByID(id: Int): LiveData<Schedule> {
        return scheduleDAOImpl.getScheduleByUserID(id)
    }
    fun deleteSchedule(schedule: Schedule) {
        return scheduleDAOImpl.delete(schedule)
    }

    fun insertSchedule(schedule: Schedule) {
        return scheduleDAOImpl.insert(schedule)
    }

    fun updateReminder(schedule: Schedule) {
        return scheduleDAOImpl.update(schedule)
    }
}