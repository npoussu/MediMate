package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.ScheduleDAO
import com.macrosoft.reminder.database.UserDAO
import com.macrosoft.reminder.database.UserDAO_Impl
import com.macrosoft.reminder.model.Schedule

class ScheduleRepository(scheduleDAO: ScheduleDAO) {
    private val scheduleDAOImpl: ScheduleDAO = scheduleDAO


    fun getScheduleByUserID(id: Int): LiveData<Array<Schedule>> {
        return scheduleDAOImpl.getScheduleByUserID(id)
    }

    fun getScheduleByMedicineID(medID: Int): LiveData<Array<Schedule>> {
        return scheduleDAOImpl.getScheduleByMedicineID(medID)
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