package com.macrosoft.reminder.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.macrosoft.reminder.data.MedicineDetails
import com.macrosoft.reminder.data.MedicineListObject
import com.macrosoft.reminder.database.MedicineDataDAO
import com.macrosoft.reminder.database.ScheduleDAO
import com.macrosoft.reminder.model.MedicineData
import com.macrosoft.reminder.model.MedicineSchedule
import com.macrosoft.reminder.model.Schedule

class MedicineRepository(medicineDataDAO: MedicineDataDAO, scheduleDAO: ScheduleDAO) {
    private val medicineDataDAOImpl: MedicineDataDAO = medicineDataDAO

    fun getMedicineSchedule(user_id: Int): LiveData<Array<MedicineSchedule>> {
        return medicineDataDAOImpl.getMedicineSchedule(user_id)
    }

    fun getMedicineDetail(med_id: IntArray): LiveData<Array<MedicineDetails>> {
        return medicineDataDAOImpl.getMedicineDetail(med_id)
    }

    fun deleteMedicineByID(id: Int) {
        return medicineDataDAOImpl.deleteMedicineByID(id)
    }

    fun insertMedicine(medicine: MedicineData): Long {
        return medicineDataDAOImpl.insert(medicine)
    }

    fun updateMedicineByID(id: Int, medicineName: String, description: String) {
        return medicineDataDAOImpl.updateMedicineByID(id, medicineName, description)
    }
}