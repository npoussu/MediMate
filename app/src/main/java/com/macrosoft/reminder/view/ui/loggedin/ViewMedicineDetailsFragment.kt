package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.data.MedicineDetailedListAdapter
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import kotlinx.android.synthetic.main.fragment_view_medicine_details.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A fragment displaying all the various medicine to be taken at X time.
 * This fragment shows the reminders in detail (shows the dosage, requirements etc).
 */
class ViewMedicineDetailsFragment : Fragment() {

    private val TAG = ViewMedicineDetailsFragment::class.java.simpleName

    // Share ViewModel with ViewMedicineFragment
    private val viewModel: ViewMedicineViewModel by sharedViewModel()

    private lateinit var adapter: MedicineDetailedListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_medicine_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        medicineDetailedList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        medicineDetailedList.setHasFixedSize(true)

        adapter = MedicineDetailedListAdapter()
        medicineDetailedList.adapter = adapter

        // Populate the adapter with shared data from ViewModel
        adapter.setDetailedList(viewModel.state.value!!)

        Log.i(TAG, viewModel.state.value!!.toString())
    }
}

