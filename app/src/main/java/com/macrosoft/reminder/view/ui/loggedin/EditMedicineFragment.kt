package com.macrosoft.reminder.view.ui.loggedin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.EditFragmentBinding
import com.macrosoft.reminder.view.ui.loggedin.AddScheduleFragment.Companion.TAG
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EditMedicineFragment : Fragment() {

    private val viewModel: ViewMedicineViewModel by sharedViewModel()

    var listener: OnPopBackStack? = null

    lateinit var binding: EditFragmentBinding

    interface OnPopBackStack {
        fun setToolbarTitle(title: String)
        fun onEditScheduleClicked()
        fun returnToViewMedicineFragment()
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

        listener?.setToolbarTitle(getString(R.string.edit))

        viewModel.setEditInputInitialValues(viewModel.itemState.value!!)

        viewModel.navigateBack.observe(viewLifecycleOwner, Observer {
            activity?.onBackPressed()
        })

        viewModel.returnToMainPage.observe(viewLifecycleOwner, Observer {
            listener!!.returnToViewMedicineFragment()
        })

        viewModel.showEditScheduleFragment.observe(viewLifecycleOwner, Observer {
            listener!!.onEditScheduleClicked()
        })


        viewModel.getSelectedMedicineSchedule().observe(this, Observer {
            viewModel.currentlySelectedSchedule.value = it
            Log.i(TAG, "selected Medince Schedule" +viewModel.currentlySelectedSchedule.value )
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.edit_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}
