package com.macrosoft.reminder.view.ui.loggedin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.ScheduleEditFragmentBinding
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.schedule_edit_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}