package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.ScheduleDAO
import com.macrosoft.reminder.database.UserDAO
import com.macrosoft.reminder.database.UserDAO_Impl
import com.macrosoft.reminder.model.Schedule
import java.sql.Date
import java.sql.Time

class ScheduleRepository(scheduleDAO: ScheduleDAO) {
    private val scheduleDAOImpl: ScheduleDAO = scheduleDAO

    fun getScheduleByMedicineID(medID: Int): LiveData<Schedule> {
        return scheduleDAOImpl.getScheduleByMedicineID(medID)
    }

    fun deleteScheduleByID(id: Int) {
        return scheduleDAOImpl.deleteScheduleByID(id)
    }

    fun insertSchedule(schedule: Schedule): Long {
        return scheduleDAOImpl.insert(schedule)
    }

    fun updateScheduleByID(id: Int, start_date: Date, end_date: Date, time: ArrayList<Time>) {
        return scheduleDAOImpl.updateScheduleByID(id, start_date, end_date, time)
    }
}