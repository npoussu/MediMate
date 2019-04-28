package com.macrosoft.reminder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.macrosoft.reminder.model.MedicineDetails
import com.macrosoft.reminder.model.MedicineDetailsList
import com.macrosoft.reminder.repository.FakeRepository

class ViewMedicineViewModel : ViewModel() {

    private val medicineDetails = LiveEvent<MedicineDetailsList>()
    val state: LiveData<MedicineDetailsList> = medicineDetails

    private val medicineDetailsItem = LiveEvent<MedicineDetails>()
    val itemState: LiveData<MedicineDetails> = medicineDetailsItem

    private val fakeMedicineDetails: LiveData<MedicineDetailsList>
        get() = FakeRepository.fakeMedicineDetails

    fun setMedicineDetailsDatabaseID(id: Int) {

        // TODO: Get the Reminder from DB using the @id parameter and set the Reminder to medicineDetails.value
        medicineDetails.value = fakeMedicineDetails.value
    }

    fun setItemState(medicineDetails: MedicineDetails) {
        medicineDetailsItem.value = medicineDetails
    }

}