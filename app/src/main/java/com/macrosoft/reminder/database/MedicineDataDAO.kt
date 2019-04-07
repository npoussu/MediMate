package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.macrosoft.reminder.model.MedicineData
import com.macrosoft.reminder.model.Reminder
import com.macrosoft.reminder.model.Schedule


@Dao
interface MedicineDataDAO {
    @Query("SELECT * FROM medicine_data where :user_id = user_id")
    fun getByUserID(user_id: Int): LiveData<MedicineData>

    @Insert
    fun insert(medicine_data: MedicineData)

    @Delete
    fun delete(medicine_data: MedicineData)
}