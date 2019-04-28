package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.macrosoft.reminder.R
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import kotlinx.android.synthetic.main.edit_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EditMedicineFragment : Fragment() {

    private val viewModel: ViewMedicineViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()

        medicineNameInput.setText(viewModel.itemState.value?.name)
        dosageInput.setText(viewModel.itemState.value?.dosage)
        requirementsInput.setText(viewModel.itemState.value?.requirements)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.edit_fragment, container, false)
    }

}
