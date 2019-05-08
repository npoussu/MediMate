package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.data.MedicineDetails
import com.macrosoft.reminder.data.MedicineListObject
import com.macrosoft.reminder.model.MedicineData
import com.macrosoft.reminder.model.MedicineSchedule
import java.sql.Date
import java.sql.Time


@Dao
interface MedicineDataDAO: BaseDao<MedicineData>{
    @Query("SELECT * FROM medicine_data where :id = id")
    fun getMedicineByID(id: Int): LiveData<MedicineData>

    @Query("SELECT * FROM medicine_data where user_id = :user_id")
    fun getMedicineByUserID(user_id: Int): LiveData<Array<MedicineData>>

    @Query("SELECT medicine_name, medicine_id, time FROM medicine_data INNER JOIN schedules ON medicine_data.id = schedules.medicine_id WHERE medicine_data.user_id = :user_id")
    fun getMedicineSchedule(user_id: Int): LiveData<Array<MedicineSchedule>>

    @Query("SELECT medicine_data.id, medicine_name, time, dosage, description FROM medicine_data INNER JOIN schedules ON medicine_data.id = schedules.medicine_id INNER JOIN reminders ON schedules.medicine_id = reminders.medicine_id WHERE medicine_data.id IN (:med_ids)")
    fun getMedicineDetail(med_ids: IntArray): LiveData<Array<MedicineDetails>>

    @Query("SELECT id FROM medicine_data")
    fun getMedicineIDs(): LiveData<Array<Int>>

    @Query("UPDATE medicine_data SET medicine_name = :medicineName, description = :description WHERE id = :id")
    fun updateMedicineByID(id: Int, medicineName: String, description: String)

    @Query("DELETE FROM medicine_data WHERE id = :id")
    fun deleteMedicineByID(id: Int)
}