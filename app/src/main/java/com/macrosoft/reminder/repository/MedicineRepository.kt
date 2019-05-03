package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.MedicineDataDAO
import com.macrosoft.reminder.model.MedicineData

class MedicineRepository(medicineDataDAO: MedicineDataDAO) {
    private val medicineDataDAOImpl: MedicineDataDAO = medicineDataDAO

    fun getMedicineByID(id: Int): LiveData<MedicineData> {
        return medicineDataDAOImpl.getMedicineByID(id)
    }

//    fun getMedicineByUserID(id: Int): LiveData<MedicineData> {
//        return medicineDataDAOImpl.getMedicineByUserID(id)
//    }
    fun getMedicineByUserID(id: Int): Array<MedicineData> {
        return medicineDataDAOImpl.getMedicineByUserID(id)
    }

    fun deleteMedicine(medicine: MedicineData) {
        return medicineDataDAOImpl.delete(medicine)
    }

    fun insertMedicine(medicine: MedicineData) {
        return medicineDataDAOImpl.insert(medicine)
    }

    fun updateMedicine(medicine: MedicineData) {
        return medicineDataDAOImpl.update(medicine)
    }
}