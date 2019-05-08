package com.macrosoft.reminder.view.ui.loggedin

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.ScheduleEditFragmentBinding
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import kotlinx.android.synthetic.main.schedule_edit_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat
import java.util.*

class EditScheduleFragment(val userID: Int) : Fragment() {

    lateinit var binding: ScheduleEditFragmentBinding

    var listener: IEditScheduleFragment? = null

    private val viewModel: ViewMedicineViewModel by sharedViewModel()

    interface IEditScheduleFragment {
        fun setToolbarTitle(title: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? IEditScheduleFragment
        if (listener == null) {
            throw ClassCastException("$context must implement IEditScheduleFragment")
        }
    }

    override fun onStart() {
        super.onStart()
        listener!!.setToolbarTitle(getString(R.string.edit_schedule))

        viewModel.showToast.observe(this, androidx.lifecycle.Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        val arrayAdapter = ArrayAdapter.createFromResource(
            context!!,
            R.array.times_to_take_medicine,
            android.R.layout.simple_spinner_dropdown_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEdit.adapter = arrayAdapter

        val calendar = Calendar.getInstance()

        viewModel.userID = userID

        // Get today's Date values (year, month, day)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)

        var dateFormatter = SimpleDateFormat("yyyy/MM/dd")
        viewModel.startDateEditContent.value =
            dateFormatter.format(viewModel.currentlySelectedSchedule.value!!.startDate)
        viewModel.endDateEditContent.value = dateFormatter.format(viewModel.currentlySelectedSchedule.value!!.endDate)

        val startDatePicker =
            DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, startYear, monthOfYear, dayOfMonth ->
                Log.i(AddScheduleFragment.TAG, "$startYear/$monthOfYear/$dayOfMonth")
                viewModel.startDateEditContent.value = "$startYear/$monthOfYear/$dayOfMonth"
            }, year, month, day)

        val endDatePicker =
            DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, endYear, monthOfYear, dayOfMonth ->
                Log.i(AddScheduleFragment.TAG, "$endYear/$monthOfYear/$dayOfMonth")
                viewModel.endDateEditContent.value = "$endYear/$monthOfYear/$dayOfMonth"
            }, year, month, day)

        viewModel.showStartDatePicker.observe(this, androidx.lifecycle.Observer {
            startDatePicker.show()
        })

        viewModel.showEndDatePicker.observe(this, androidx.lifecycle.Observer {
            endDatePicker.show()
        })

        viewModel.navigateBack.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            activity?.onBackPressed()
        })

        var userSelectedTimes = viewModel.currentlySelectedSchedule.value!!.time

        viewModel.spinnerEditIdItemPosition.value = userSelectedTimes.size - 1

        for (i in 0..userSelectedTimes.size - 1) {
            var reminderEditContent = getReminderTime(i)
//            Log.i("TIME!", userSelectedTimes[i].toString().substring(0,5))
            reminderEditContent?.value = userSelectedTimes[i].toString().substring(0, 5)
        }

        val timePickerDialogOne = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(AddScheduleFragment.TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeOneEdit.text = "$h:0$m"
            } else {
                reminderTimeOneEdit.text = "$h:$m"
            }

        }), hour, minute, false)

        val timePickerDialogTwo = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(AddScheduleFragment.TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeTwoEdit.text = "$h:0$m"
            } else {
                reminderTimeTwoEdit.text = "$h:$m"
            }

        }), hour, minute, false)

        val timePickerDialogThree =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(AddScheduleFragment.TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeThreeEdit.text = "$h:0$m"
                } else {
                    reminderTimeThreeEdit.text = "$h:$m"
                }

            }), hour, minute, false)

        val timePickerDialogFour =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(AddScheduleFragment.TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeFourEdit.text = "$h:0$m"
                } else {
                    reminderTimeFourEdit.text = "$h:$m"
                }

            }), hour, minute, false)

        val timePickerDialogFive =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(AddScheduleFragment.TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeFiveEdit.text = "$h:0$m"
                } else {
                    reminderTimeFiveEdit.text = "$h:$m"
                }

            }), hour, minute, false)

        val timePickerDialogSix = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(AddScheduleFragment.TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeSixEdit.text = "$h:0$m"
            } else {
                reminderTimeSixEdit.text = "$h:$m"
            }

        }), hour, minute, false)

        val timePickerDialogSeven =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(AddScheduleFragment.TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeSevenEdit.text = "$h:0$m"
                } else {
                    reminderTimeSevenEdit.text = "$h:$m"
                }

            }), hour, minute, false)

        val timePickerDialogEight =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(AddScheduleFragment.TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeEightEdit.text = "$h:0$m"
                } else {
                    reminderTimeEightEdit.text = "$h:$m"
                }

            }), hour, minute, false)

        val timePickerDialogNine =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(AddScheduleFragment.TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeNineEdit.text = "$h:0$m"
                } else {
                    reminderTimeNineEdit.text = "$h:$m"
                }

            }), hour, minute, false)

        val timePickerDialogTen = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(AddScheduleFragment.TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeTenEdit.text = "$h:0$m"
            } else {
                reminderTimeTenEdit.text = "$h:$m"
            }

        }), hour, minute, false)

        reminderTimeOneEdit.setOnClickListener {
            timePickerDialogOne.show()
        }

        reminderTimeTwoEdit.setOnClickListener {
            timePickerDialogTwo.show()
        }


        reminderTimeThreeEdit.setOnClickListener {
            timePickerDialogThree.show()
        }

        reminderTimeFourEdit.setOnClickListener {
            timePickerDialogFour.show()
        }

        reminderTimeFiveEdit.setOnClickListener {
            timePickerDialogFive.show()
        }

        reminderTimeSixEdit.setOnClickListener {
            timePickerDialogSix.show()
        }

        reminderTimeSevenEdit.setOnClickListener {
            timePickerDialogSeven.show()
        }

        reminderTimeEightEdit.setOnClickListener {
            timePickerDialogEight.show()
        }

        reminderTimeNineEdit.setOnClickListener {
            timePickerDialogNine.show()
        }

        reminderTimeTenEdit.setOnClickListener {
            timePickerDialogTen.show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.schedule_edit_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

    private fun getReminderTime(num: Int): MutableLiveData<String>? {
        val reminderTimeMap = hashMapOf(
            0 to viewModel.reminderTimeOneEditContent,
            1 to viewModel.reminderTimeTwoEditContent,
            2 to viewModel.reminderTimeThreeEditContent,
            3 to viewModel.reminderTimeFourEditContent,
            4 to viewModel.reminderTimeFiveEditContent,
            5 to viewModel.reminderTimeSixEditContent,
            6 to viewModel.reminderTimeSevenEditContent,
            7 to viewModel.reminderTimeEightEditContent,
            8 to viewModel.reminderTimeNineEditContent,
            9 to viewModel.reminderTimeTenEditContent
        )
        return reminderTimeMap[num]
    }
}