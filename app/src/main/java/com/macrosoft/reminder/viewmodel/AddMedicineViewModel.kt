package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.macrosoft.reminder.data.MedicineDetails
import com.macrosoft.reminder.model.MedicineData
import com.macrosoft.reminder.model.Reminder
import com.macrosoft.reminder.model.Schedule
import com.macrosoft.reminder.repository.MedicineRepository
import com.macrosoft.reminder.repository.ReminderRepository
import com.macrosoft.reminder.repository.ScheduleRepository
import java.lang.Thread.sleep
import java.sql.Date
import java.sql.Time
import java.text.SimpleDateFormat

class AddMedicineViewModel(
    private val med_repo: MedicineRepository,
    private val reminder_repo: ReminderRepository,
    private val schedule_repo: ScheduleRepository
) : ObservableViewModel() {

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

    // Reminder Times Bindings
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

    // Reminder Weekdays selected Bindings
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

    // Single LiveEvents
    val showAddScheduleFragment = LiveEvent<Boolean>()

    val showStartDatePicker = LiveEvent<Boolean>()

    val showEndDatePicker = LiveEvent<Boolean>()

    val triggerMedicineReminderDialog = LiveEvent<MedicineDetails>()

    val triggerMedicineReminderDialogRTC = LiveEvent<MedicineDetails>()

    val navigateBack = LiveEvent<Boolean>()

    // Start/End Date Bindings
    @Bindable
    val startDateAddContent = MutableLiveData<String>()

    @Bindable
    val endDateAddContent = MutableLiveData<String>()

    val showToast = LiveEvent<String>()
    var userID = 0

    var newMed: MedicineData? = null
    var newReminder: Reminder? = null
    var newSchedule: Schedule? = null
    var ifScheduleIsSet: Boolean = false


    // Initialize the Reminder fields
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

    // Triggers opening AddScheduleFragment
    fun onScheduleClick() {

        Log.i(TAG, "onScheduleClick()")

        Log.i(TAG, "Medicine name: " + medicineNameInputContent.value)
        Log.i(TAG, "Dosage: " + dosageInputContent.value)
        Log.i(TAG, "Requirements: " + requirementsInputContent.value)

        showAddScheduleFragment.value = true
    }

    fun onSaveMedClick() {
        if (medicineNameInputContent.value == null) {
            showToast.value = "Medicine name cant be null"
        } else if (dosageInputContent.value == null) {
            showToast.value = "Dosage cant be null"
        } else if (requirementsInputContent.value == null) {
            showToast.value = "Requirements cant be null"
        } else {
            newMed = MedicineData(userID, medicineNameInputContent.value!!, requirementsInputContent.value)

            if (ifScheduleIsSet) {
                val newMed_id = med_repo.insertMedicine(newMed!!)
                newSchedule!!.medicineID = newMed_id.toInt()
                newReminder!!.medicineID = newMed_id.toInt()
                schedule_repo.insertSchedule(newSchedule!!)
                reminder_repo.insertReminder(newReminder!!)
                showToast.value = "Medicine Saved!"
                ifScheduleIsSet = false
                navigateBack.value = true
            } else {
                showToast.value = "Please Select Schedule"
            }
        }

        ifScheduleIsSet = false

        Log.i(TAG, "Medicine name: " + medicineNameInputContent.value)
        Log.i(TAG, "Dosage: " + dosageInputContent.value)
        Log.i(TAG, "Requirements: " + requirementsInputContent.value)
        Log.i(TAG, "onSaveMedClick()")
    }

    // For debug logging
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

    // Triggers opening the DatePickerDialog for selecting End Date of Reminder
    fun onSelectEndDateClick() {
        Log.i(TAG, "onSelectEndDateClick()")
        showEndDatePicker.value = true
    }

    // Triggers opening the DatePickerDialog for selecting Start Date of Reminder
    fun onSelectStartDateClick() {
        Log.i(TAG, "onSelectStartDateClick()")
        showStartDatePicker.value = true
    }

    // To save the schedule
    fun onSaveButtonClick() {
        // TODO: Save the reminder and setup Alarms here

        val userInputTimes: ArrayList<String?> = arrayListOf(
            reminderTimeOneAddContent.value,
            reminderTimeTwoAddContent.value,
            reminderTimeThreeAddContent.value,
            reminderTimeFourAddContent.value,
            reminderTimeFiveAddContent.value,
            reminderTimeSixAddContent.value,
            reminderTimeSevenAddContent.value,
            reminderTimeEightAddContent.value,
            reminderTimeNineAddContent.value,
            reminderTimeTenAddContent.value
        )
        val userSelectedTimes: ArrayList<Time> = arrayListOf()
        val timeFormatter = SimpleDateFormat("HH:mm")
        val dateFormatter = SimpleDateFormat("yyyy/MM/dd")

        if (startDateAddContent.value == null) {
            showToast.value = "Please Select Start Date"
        } else if (endDateAddContent.value == null) {
            showToast.value = "Please Select End Date"
        } else {
            for (i in 0..spinnerAddIdItemPosition.value!!.toInt()) {
                val parsedTime = timeFormatter.parse(userInputTimes[i])
                val time = Time(parsedTime.time)
                userSelectedTimes.add(time)
            }

            val startDate = Date(dateFormatter.parse(startDateAddContent.value).time)
            val endDate = Date(dateFormatter.parse(endDateAddContent.value).time)

            newSchedule = Schedule(userID, 0, startDate, endDate, false, userSelectedTimes)
            newReminder = Reminder(
                userID,
                0,
                userSelectedTimes.toString(),
                "Default",
                dosageInputContent.value!!,
                null
            )
            ifScheduleIsSet = true
            showToast.value = "Schedule Saved!"
            showAddScheduleFragment.value = true

            // Setup alarm
            if (medicineNameInputContent.value != null && dosageInputContent.value != null && requirementsInputContent.value != null) {
                triggerMedicineReminderDialog.value = MedicineDetails(
                    1,
                    medicineNameInputContent.value!!,
                    "8:00AM",
                    dosageInputContent.value!!,
                    requirementsInputContent.value!!
                )
            }
            navigateBack.value = true

        }
    }

    fun onSaveButtonRTCClick() {
        Log.i(TAG, "onSaveButtonClick()")

        if (medicineNameInputContent.value != null && dosageInputContent.value != null && requirementsInputContent.value != null) {
            triggerMedicineReminderDialogRTC.value = MedicineDetails(
                1,
                medicineNameInputContent.value!!, reminderTimeOneAddContent.value.toString(),
                dosageInputContent.value!!, requirementsInputContent.value!!
            )
        }
    }
}