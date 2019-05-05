package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent

class AddMedicineViewModel : ObservableViewModel() {

    companion object {
        val TAG: String = AddMedicineViewModel::class.java.simpleName
    }

    @Bindable
    val medicineNameInputContent = MutableLiveData<String>()

    @Bindable
    val dosageInputContent = MutableLiveData<String>()

    @Bindable
    val requirementsInputContent = MutableLiveData<String>()

    val showAddScheduleFragment = LiveEvent<Boolean>()

    val showStartDatePicker = LiveEvent<Boolean>()

    val showEndDatePicker = LiveEvent<Boolean>()


    fun onScheduleClick() {

        Log.i(TAG, "onScheduleClick()")

        Log.i(TAG, "Medicine name: " + medicineNameInputContent.value)
        Log.i(TAG, "Dosage: " + dosageInputContent.value)
        Log.i(TAG, "Requirements: " + requirementsInputContent.value)

        showAddScheduleFragment.value = true
    }

    fun onSaveMedClick() {

        // TODO: Update itemState here and update the DB entity "MedicineDetailsList" to save the new values
        Log.i(TAG, "onSaveMedClick()")
    }

    fun onSelectFrequencyClick() {
        Log.i(TAG, "onSelectFrequencyClick()")
    }

    fun onSelectEndDateClick() {
        Log.i(TAG, "onSelectEndDateClick()")
        showEndDatePicker.value = true
    }

    fun onSelectStartDateClick() {
        Log.i(TAG, "onSelectStartDateClick()")
        showStartDatePicker.value = true
    }
}