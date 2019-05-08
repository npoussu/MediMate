package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.model.Schedule
import java.sql.Date
import java.sql.Time


@Dao
interface ScheduleDAO : BaseDao<Schedule>{
    @Query("SELECT * FROM schedules where user_id = :user_id")
    fun getScheduleByUserID(user_id: Int): LiveData<Array<Schedule>>

    @Query("SELECT * FROM schedules where medicine_id = :med_id")
    fun getScheduleByMedicineID(med_id: Int): LiveData<Schedule>

    @Query("UPDATE schedules SET start_date = :start_date, end_date = :end_date, time = :time WHERE id = :id")
    fun updateScheduleByID(id: Int, start_date: Date, end_date: Date, time: ArrayList<Time>)

    @Query("DELETE FROM schedules WHERE id = :id")
    fun deleteScheduleByID(id: Int)
}