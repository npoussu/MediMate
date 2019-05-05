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

    @Bindable
    val spinnerAddIdItemPosition = MutableLiveData<Int>()

    @Bindable
    val reminderTimeOneAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeTwoAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeThreeAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeFourAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeFiveAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeSixAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeSevenAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeEightAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeNineAddContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeTenAddContent = MutableLiveData<String>()

    @Bindable
    val reminderMondayAddChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderTuesdayAddChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderWednesdayAddChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderThursdayAddChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderFridayAddChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderSaturdayAddChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderSundayAddChecked = MutableLiveData<Boolean>()

    val showAddScheduleFragment = LiveEvent<Boolean>()

    val showStartDatePicker = LiveEvent<Boolean>()

    val showEndDatePicker = LiveEvent<Boolean>()

    @Bindable
    val startDateAddContent = MutableLiveData<String>()

    @Bindable
    val endDateAddContent = MutableLiveData<String>()

    init {
        reminderTimeOneAddContent.value = "8:00"
        reminderTimeTwoAddContent.value = "9:00"
        reminderTimeThreeAddContent.value = "10:00"
        reminderTimeFourAddContent.value = "11:00"
        reminderTimeFiveAddContent.value = "12:00"
        reminderTimeSixAddContent.value = "13:00"
        reminderTimeSevenAddContent.value = "14:00"
        reminderTimeEightAddContent.value = "15:00"
        reminderTimeNineAddContent.value = "16:00"
        reminderTimeTenAddContent.value = "17:00"

        reminderMondayAddChecked.value = false
        reminderTuesdayAddChecked.value = false
        reminderWednesdayAddChecked.value = false
        reminderThursdayAddChecked.value = false
        reminderFridayAddChecked.value = false
        reminderSaturdayAddChecked.value = false
        reminderSundayAddChecked.value = false

    }

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
        Log.i(TAG, spinnerAddIdItemPosition.value.toString())
        Log.i(TAG, "First reminder: " + reminderTimeOneAddContent.value)
        Log.i(TAG, "Second reminder: " + reminderTimeTwoAddContent.value)
        Log.i(TAG, "Third reminder: " + reminderTimeThreeAddContent.value)
        Log.i(TAG, "Fourth reminder: " + reminderTimeFourAddContent.value)
        Log.i(TAG, "Fifth reminder: " + reminderTimeFiveAddContent.value)
        Log.i(TAG, "Sixth reminder: " + reminderTimeSixAddContent.value)
        Log.i(TAG, "Seventh reminder: " + reminderTimeSevenAddContent.value)
        Log.i(TAG, "Eight reminder: " + reminderTimeEightAddContent.value)
        Log.i(TAG, "Ninth reminder: " + reminderTimeNineAddContent.value)
        Log.i(TAG, "Tenth reminder: " + reminderTimeTenAddContent.value)

        Log.i(TAG, "Monday reminder checked: " + reminderMondayAddChecked.value)
        Log.i(TAG, "Tuesday reminder checked: " + reminderTuesdayAddChecked.value)
        Log.i(TAG, "Wednesday reminder checked: " + reminderWednesdayAddChecked.value)
        Log.i(TAG, "Thursday reminder checked: " + reminderThursdayAddChecked.value)
        Log.i(TAG, "Friday reminder checked: " + reminderFridayAddChecked.value)
        Log.i(TAG, "Saturday reminder checked: " + reminderSaturdayAddChecked.value)
        Log.i(TAG, "Sunday reminder checked: " + reminderSundayAddChecked.value)
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