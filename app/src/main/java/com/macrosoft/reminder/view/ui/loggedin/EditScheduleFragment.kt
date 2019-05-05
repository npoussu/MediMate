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
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.ScheduleEditFragmentBinding
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import kotlinx.android.synthetic.main.schedule_edit_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class EditScheduleFragment : Fragment() {

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

        val arrayAdapter = ArrayAdapter.createFromResource(
            context!!,
            R.array.times_to_take_medicine,
            android.R.layout.simple_spinner_dropdown_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEdit.adapter = arrayAdapter

        val calendar = Calendar.getInstance()

        // Get today's Date values (year, month, day)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val startDatePicker =
            DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, startYear, monthOfYear, dayOfMonth ->
                Log.i(AddScheduleFragment.TAG, "$startYear/$monthOfYear/$dayOfMonth")
            }, year, month, day)

        val endDatePicker =
            DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, endYear, monthOfYear, dayOfMonth ->
                Log.i(AddScheduleFragment.TAG, "$endYear/$monthOfYear/$dayOfMonth")
            }, year, month, day)

        viewModel.showStartDatePicker.observe(this, androidx.lifecycle.Observer {
            startDatePicker.show()
        })

        viewModel.showEndDatePicker.observe(this, androidx.lifecycle.Observer {
            endDatePicker.show()
        })

        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)

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

}