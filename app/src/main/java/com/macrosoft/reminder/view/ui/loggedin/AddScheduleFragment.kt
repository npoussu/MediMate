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
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.ScheduleAddFragmentBinding
import com.macrosoft.reminder.viewmodel.AddMedicineViewModel
import kotlinx.android.synthetic.main.schedule_add_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class AddScheduleFragment : Fragment() {

    companion object {
        val TAG = AddScheduleFragment::class.java.simpleName
    }

    lateinit var binding: ScheduleAddFragmentBinding

    var listener: IAddScheduleFragment? = null

    private val viewModel: AddMedicineViewModel by sharedViewModel()

    private val mNotificationTime =
        Calendar.getInstance().timeInMillis + 5000 //Set after 5 seconds from the current time.
    private var mNotified = false

    interface IAddScheduleFragment {
        fun setToolbarTitle(title: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? IAddScheduleFragment
        if (listener == null) {
            throw ClassCastException("$context must implement IAddScheduleFragment")
        }
    }

    override fun onStart() {
        super.onStart()
        listener!!.setToolbarTitle(getString(R.string.add_schedule))

        val arrayAdapter = ArrayAdapter.createFromResource(
            context!!,
            R.array.times_to_take_medicine,
            android.R.layout.simple_spinner_dropdown_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAdd.adapter = arrayAdapter

        val calendar = Calendar.getInstance()

        // Get today's Date values (year, month, day)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)

        val startDatePicker =
            DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, startYear, monthOfYear, dayOfMonth ->
                Log.i(TAG, "$startYear/$monthOfYear/$dayOfMonth")
                viewModel.startDateAddContent.value = "$startYear/$monthOfYear/$dayOfMonth"
            }, year, month, day)

        val endDatePicker =
            DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, endYear, monthOfYear, dayOfMonth ->
                Log.i(TAG, "$endYear/$monthOfYear/$dayOfMonth")
                viewModel.endDateAddContent.value = "$endYear/$monthOfYear/$dayOfMonth"
            }, year, month, day)

        viewModel.showStartDatePicker.observe(this, androidx.lifecycle.Observer {
            startDatePicker.show()
        })

        viewModel.showEndDatePicker.observe(this, androidx.lifecycle.Observer {
            endDatePicker.show()
        })

        val timePickerDialogOne = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeOneAdd.text = "$h:0$m"
            } else {
                reminderTimeOneAdd.text = "$h:$m"
            }

        }), hour, minute, true)

        val timePickerDialogTwo = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeTwoAdd.text = "$h:0$m"
            } else {
                reminderTimeTwoAdd.text = "$h:$m"
            }

        }), hour, minute, true)

        val timePickerDialogThree =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeThreeAdd.text = "$h:0$m"
                } else {
                    reminderTimeThreeAdd.text = "$h:$m"
                }

            }), hour, minute, true)

        val timePickerDialogFour =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeFourAdd.text = "$h:0$m"
                } else {
                    reminderTimeFourAdd.text = "$h:$m"
                }

            }), hour, minute, true)

        val timePickerDialogFive =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeFiveAdd.text = "$h:0$m"
                } else {
                    reminderTimeFiveAdd.text = "$h:$m"
                }

            }), hour, minute, true)

        val timePickerDialogSix = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeSixAdd.text = "$h:0$m"
            } else {
                reminderTimeSixAdd.text = "$h:$m"
            }

        }), hour, minute, true)

        val timePickerDialogSeven =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeSevenAdd.text = "$h:0$m"
                } else {
                    reminderTimeSevenAdd.text = "$h:$m"
                }

            }), hour, minute, true)

        val timePickerDialogEight =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeEightAdd.text = "$h:0$m"
                } else {
                    reminderTimeEightAdd.text = "$h:$m"
                }

            }), hour, minute, true)

        val timePickerDialogNine =
            TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

                Log.i(TAG, "$h : $m : ")
                if (m < 10) {
                    reminderTimeNineAdd.text = "$h:0$m"
                } else {
                    reminderTimeNineAdd.text = "$h:$m"
                }

            }), hour, minute, true)

        val timePickerDialogTen = TimePickerDialog(context!!, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->

            Log.i(TAG, "$h : $m : ")
            if (m < 10) {
                reminderTimeTenAdd.text = "$h:0$m"
            } else {
                reminderTimeTenAdd.text = "$h:$m"
            }

        }), hour, minute, true)

        reminderTimeOneAdd.setOnClickListener {
            timePickerDialogOne.show()
        }

        reminderTimeTwoAdd.setOnClickListener {
            timePickerDialogTwo.show()
        }


        reminderTimeThreeAdd.setOnClickListener {
            timePickerDialogThree.show()
        }

        reminderTimeFourAdd.setOnClickListener {
            timePickerDialogFour.show()
        }

        reminderTimeFiveAdd.setOnClickListener {
            timePickerDialogFive.show()
        }

        reminderTimeSixAdd.setOnClickListener {
            timePickerDialogSix.show()
        }

        reminderTimeSevenAdd.setOnClickListener {
            timePickerDialogSeven.show()
        }

        reminderTimeEightAdd.setOnClickListener {
            timePickerDialogEight.show()
        }

        reminderTimeNineAdd.setOnClickListener {
            timePickerDialogNine.show()
        }

        reminderTimeTenAdd.setOnClickListener {
            timePickerDialogTen.show()
        }

        viewModel.navigateBack.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            activity?.onBackPressed()
        })

        viewModel.showToast.observe(this, androidx.lifecycle.Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.triggerMedicineReminderDialog.observe(this, androidx.lifecycle.Observer {
            if (!mNotified) {
                NotificationUtils().setNotification(it.medicine_name, it.dosage, it.description, mNotificationTime, activity!!)
            }
        })

        viewModel.triggerMedicineReminderDialogRTC.observe(this, androidx.lifecycle.Observer {
            if (!mNotified) {
                val timeSeparated: List<String> = it.time.split(":")
                Log.i(TAG, "Hour: " + timeSeparated[0] + "Minute: " + timeSeparated[1])
                NotificationUtils().setNotificationRTC(
                    true,
                    it.medicine_name,
                    it.dosage,
                    it.description,
                    timeSeparated[0].toInt(),
                    timeSeparated[1].toInt(),
                    activity!!
                )
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.schedule_add_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}