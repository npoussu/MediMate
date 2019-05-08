package com.macrosoft.reminder.view.ui.loggedin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.FragmentAddReminderBinding
import com.macrosoft.reminder.viewmodel.AddMedicineViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AddMedicineFragment(val userID: Int) : Fragment() {

    private val viewModel: AddMedicineViewModel by sharedViewModel()

    var listener: OnPopBackStack? = null

    lateinit var binding: FragmentAddReminderBinding

    interface OnPopBackStack {
        fun setToolbarTitle(title: String)
        fun onAddScheduleClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnPopBackStack
        if (listener == null) {
            throw ClassCastException("$context must implement OnPopBackStack")
        }
    }

    override fun onStart() {
        super.onStart()

        listener?.setToolbarTitle(getString(R.string.add_reminder))

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.userID = userID

        viewModel.showToast.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.showAddScheduleFragment.observe(viewLifecycleOwner, Observer {
            listener!!.onAddScheduleClicked()
        })

        viewModel.navigateBack.observe(viewLifecycleOwner, Observer {
            activity?.onBackPressed()
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_reminder, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}