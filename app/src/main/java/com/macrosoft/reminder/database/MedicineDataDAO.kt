package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.macrosoft.reminder.model.MedicineData



@Dao
interface MedicineDataDAO: BaseDao<MedicineData>{
    @Query("SELECT * FROM medicine_data where :id = id")
    fun getMedicineByID(Id: Int): LiveData<MedicineData>

}