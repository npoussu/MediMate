package com.macrosoft.reminder.view.ui.loggedin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.ScheduleFragmentBinding

class ScheduleFragment : Fragment() {

    lateinit var binding: ScheduleFragmentBinding

    var listener: IScheduleFragment? = null

    interface IScheduleFragment {
        fun setToolbarTitle(title: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? IScheduleFragment
        if (listener == null) {
            throw ClassCastException("$context must implement IScheduleFragment")
        }
    }

    override fun onStart() {
        super.onStart()
        listener!!.setToolbarTitle(getString(R.string.schedule))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.schedule_fragment, container, false)
        binding.lifecycleOwner = this
        //binding.viewmodel = viewModel
        return binding.root
    }

}