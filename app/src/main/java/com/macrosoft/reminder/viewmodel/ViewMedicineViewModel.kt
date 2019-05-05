package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.macrosoft.reminder.model.MedicineDetails
import com.macrosoft.reminder.model.MedicineDetailsList
import com.macrosoft.reminder.repository.FakeRepository

class ViewMedicineViewModel : ObservableViewModel() {

    companion object {
        private val TAG = ViewMedicineViewModel::class.java.simpleName
    }

    @Bindable
    val medicineNameInputContent = MutableLiveData<String>()

    @Bindable
    val dosageInputContent = MutableLiveData<String>()

    @Bindable
    val requirementsInputContent = MutableLiveData<String>()

    private val medicineDetails = LiveEvent<MedicineDetailsList>()
    val state: LiveData<MedicineDetailsList> = medicineDetails

    private val medicineDetailsItem = LiveEvent<MedicineDetails>()
    val itemState: LiveData<MedicineDetails> = medicineDetailsItem

    private val fakeMedicineDetails: LiveData<MedicineDetailsList>
        get() = FakeRepository.fakeMedicineDetails

    private val showAddReminderFragment = LiveEvent<Boolean>()
    val addReminderFragmentState: LiveData<Boolean> = showAddReminderFragment

    // Single LiveEvents
    val showEditScheduleFragment = LiveEvent<Boolean>()

    val showStartDatePicker = LiveEvent<Boolean>()

    val showEndDatePicker = LiveEvent<Boolean>()

    // Reminder Times Bindings
    @Bindable
    val reminderTimeOneEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeTwoEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeThreeEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeFourEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeFiveEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeSixEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeSevenEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeEightEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeNineEditContent = MutableLiveData<String>()

    @Bindable
    val reminderTimeTenEditContent = MutableLiveData<String>()

    // Reminder Weekdays selected Bindings
    @Bindable
    val reminderMondayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderTuesdayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderWednesdayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderThursdayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderFridayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderSaturdayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val reminderSundayEditChecked = MutableLiveData<Boolean>()

    @Bindable
    val spinnerEditIdItemPosition = MutableLiveData<Int>()

    @Bindable
    val startDateEditContent = MutableLiveData<String>()

    @Bindable
    val endDateEditContent = MutableLiveData<String>()

    // Initialize the Reminder fields
    init {
        reminderTimeOneEditContent.value = "8:00"
        reminderTimeTwoEditContent.value = "9:00"
        reminderTimeThreeEditContent.value = "10:00"
        reminderTimeFourEditContent.value = "11:00"
        reminderTimeFiveEditContent.value = "12:00"
        reminderTimeSixEditContent.value = "13:00"
        reminderTimeSevenEditContent.value = "14:00"
        reminderTimeEightEditContent.value = "15:00"
        reminderTimeNineEditContent.value = "16:00"
        reminderTimeTenEditContent.value = "17:00"

        reminderMondayEditChecked.value = false
        reminderTuesdayEditChecked.value = false
        reminderWednesdayEditChecked.value = false
        reminderThursdayEditChecked.value = false
        reminderFridayEditChecked.value = false
        reminderSaturdayEditChecked.value = false
        reminderSundayEditChecked.value = false
    }

    fun setMedicineDetailsDatabaseID(id: Int) {

        // TODO: Get the Reminder from DB using the @id parameter and set the Reminder to medicineDetails.value
        medicineDetails.value = fakeMedicineDetails.value
    }

    // The State represents the currently selected medicine to be edited, this method sets the state
    fun setItemState(medicineDetails: MedicineDetails) {
        medicineDetailsItem.value = medicineDetails
    }

    // Triggers opening AddScheduleFragment
    fun onScheduleClick() {

        // TODO: Open date picker on click to select schedule
        Log.i(TAG, "onScheduleClick()")

        Log.i(TAG, medicineNameInputContent.value)
        Log.i(TAG, dosageInputContent.value)
        Log.i(TAG, requirementsInputContent.value)

        showEditScheduleFragment.value = true
    }

    fun onDeleteMedClick() {

        // TODO: Update the DB entity "MedicineDetailsList" by deleting a medicine "MedicineDetails" member variable from the current DB entity
        Log.i(TAG, "onDeleteMedClick()")
    }

    fun onSaveMedClick() {

        // TODO: Update itemState here and update the DB entity "MedicineDetailsList" to save the new values
        Log.i(TAG, "onSaveMedClick()")
    }

    // Set the initial values of the Bindable EditText fields onStart() from the Observer (Fragment) according to the State
    fun setEditInputInitialValues(itemState: MedicineDetails) {

        Log.i(TAG, "setEditInputInitialValues()")

        medicineNameInputContent.value = itemState.name
        dosageInputContent.value = itemState.dosage
        requirementsInputContent.value = itemState.requirements
    }

    fun onAddMedicineClick() {
        Log.i(TAG, "onAddMedicineClick()")
        showAddReminderFragment.value = true
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

    // For debug logging
    fun onSelectFrequencyClick() {
        Log.i(TAG, "onSelectFrequencyClick()")
        Log.i(TAG, spinnerEditIdItemPosition.value.toString())

        Log.i(TAG, "First reminder: " + reminderTimeOneEditContent.value)
        Log.i(TAG, "Second reminder: " + reminderTimeTwoEditContent.value)
        Log.i(TAG, "Third reminder: " + reminderTimeThreeEditContent.value)
        Log.i(TAG, "Fourth reminder: " + reminderTimeFourEditContent.value)
        Log.i(TAG, "Fifth reminder: " + reminderTimeFiveEditContent.value)
        Log.i(TAG, "Sixth reminder: " + reminderTimeSixEditContent.value)
        Log.i(TAG, "Seventh reminder: " + reminderTimeSevenEditContent.value)
        Log.i(TAG, "Eight reminder: " + reminderTimeEightEditContent.value)
        Log.i(TAG, "Ninth reminder: " + reminderTimeNineEditContent.value)
        Log.i(TAG, "Tenth reminder: " + reminderTimeTenEditContent.value)


        Log.i(TAG, "Monday reminder checked: " + reminderMondayEditChecked.value)
        Log.i(TAG, "Tuesday reminder checked: " + reminderTuesdayEditChecked.value)
        Log.i(TAG, "Wednesday reminder checked: " + reminderWednesdayEditChecked.value)
        Log.i(TAG, "Thursday reminder checked: " + reminderThursdayEditChecked.value)
        Log.i(TAG, "Friday reminder checked: " + reminderFridayEditChecked.value)
        Log.i(TAG, "Saturday reminder checked: " + reminderSaturdayEditChecked.value)
        Log.i(TAG, "Sunday reminder checked: " + reminderSundayEditChecked.value)
    }

    fun onSaveButtonClick() {
        // TODO: Save the reminder and setup Alarms here
        Log.i(TAG, "onSaveButtonClick()")
    }
}