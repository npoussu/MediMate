package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.macrosoft.reminder.data.MedicineDetails
import com.macrosoft.reminder.data.MedicineDetailsList
import com.macrosoft.reminder.model.User

/**
 * Mock repository holding various test data
 */
object FakeRepository {

    private val _fakeUser = MutableLiveData<User>()
    private val _fakeMedicineDetails = MutableLiveData<MedicineDetailsList>()

    init {
        _fakeUser.value = User("mary", "maryodriscoll", "password123")
        val medicineDetails = listOf(
            MedicineDetails(
                "Paracetamol", "8:00AM", "2 pills", "With water"
            ), MedicineDetails(
                "Alpha E", "8:00AM", "2 pills", "-"
            ), MedicineDetails(
                "Donepezil", "8:00AM", "4 pills", "Lorem ipsum"
            ), MedicineDetails(
                "Vitamin E", "8:00AM", "1 pill", "Just do it"
            )
        )
        _fakeMedicineDetails.value = MedicineDetailsList(5, medicineDetails)
    }

    val fakeUser: LiveData<User>
        get() = _fakeUser

    val fakeMedicineDetails: LiveData<MedicineDetailsList>
        get() = _fakeMedicineDetails

}