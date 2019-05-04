package com.macrosoft.reminder.view.ui.loggedin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.ScheduleAddFragmentBinding
import com.macrosoft.reminder.viewmodel.AddMedicineViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AddScheduleFragment : Fragment() {

    lateinit var binding: ScheduleAddFragmentBinding

    var listener: IAddScheduleFragment? = null

    private val viewModel: AddMedicineViewModel by sharedViewModel()

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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.schedule_add_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}