package com.macrosoft.reminder.view.ui.loggedin

import android.app.DatePickerDialog
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

        reminderTimeOneEdit.text = "8:00"
        reminderTimeTwoEdit.text = "8:00"
        reminderTimeThreeEdit.text = "8:00"
        reminderTimeFourEdit.text = "8:00"
        reminderTimeFiveEdit.text = "8:00"
        reminderTimeSixEdit.text = "8:00"
        reminderTimeSevenEdit.text = "8:00"
        reminderTimeEightEdit.text = "8:00"
        reminderTimeNineEdit.text = "8:00"
        reminderTimeTenEdit.text = "8:00"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.schedule_edit_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}