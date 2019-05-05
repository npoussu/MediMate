package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.model.Schedule


@Dao
interface ScheduleDAO : BaseDao<Schedule>{
    @Query("SELECT * FROM schedules where user_id = :user_id")
    fun getScheduleByUserID(user_id: Int): LiveData<Array<Schedule>>

    @Query("SELECT * FROM schedules where medicine_id = :med_id")
    fun getScheduleByMedicineID(med_id: Int): LiveData<Array<Schedule>>
}