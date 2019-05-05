package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.model.MedicineData


@Dao
interface MedicineDataDAO: BaseDao<MedicineData>{
    @Query("SELECT * FROM medicine_data where :id = id")
    fun getMedicineByID(id: Int): LiveData<MedicineData>

    @Query("SELECT * FROM medicine_data where user_id = :id")
    fun getMedicineByUserID(id: Int): LiveData<Array<MedicineData>>
}