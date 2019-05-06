package com.macrosoft.reminder.view.ui.loggedin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.adapter.MedicineDetailedListAdapter
import com.macrosoft.reminder.data.MedicineDetails
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

    var listener: OnDetailedListCardClickedListener? = null

    interface OnDetailedListCardClickedListener {
        fun onDetailedListCardClick()
        fun setToolbarTitle(title: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnDetailedListCardClickedListener
        if (listener == null) {
            throw ClassCastException("$context must implement OnDetailedListCardClickedListener")
        }
    }

    override fun onStart() {
        super.onStart()
        listener?.setToolbarTitle(getString(R.string.my_medicines_title))
    }

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

        adapter.setOnItemClickListener(object : MedicineDetailedListAdapter.OnItemClickListener {
            override fun onClick(pos: Int) {
                Log.i(TAG, "Clicked adapter pos: $pos")

                // Get the MedicineDetails object of the clicked item at the list
                val medicine = adapter.getMedicineDetailsListAt(pos)

                viewModel.setItemState(medicine)
                listener?.onDetailedListCardClick()
            }
        })
    }
}

