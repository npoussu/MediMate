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
import com.macrosoft.reminder.data.MedicineListAdapter
import com.macrosoft.reminder.model.MedicineListObject
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import kotlinx.android.synthetic.main.view_medicine_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * ViewMedicineFragment: Main screen of the application. Displays a list of card representing medicine to be taken at
 * certain times
 */
class ViewMedicineFragment : Fragment() {

    private val TAG = ViewMedicineFragment::class.java.simpleName

    // Share ViewModel with ViewMedicineDetailsFragment
    private val viewModel: ViewMedicineViewModel by sharedViewModel()

    var listener: OnMedicineCardClickedListener? = null

    interface OnMedicineCardClickedListener {
        fun onCreateAccountClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnMedicineCardClickedListener
        if (listener == null) {
            throw ClassCastException("$context must implement OnMedicineCardClickedListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_medicine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        medicineList_main.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        // Initialize adapter for the RecyclerView with MedicineListObjects
        // ID = database ID for reminder
        val adapter = MedicineListAdapter()

        medicineList_main.adapter = adapter

        adapter.setMedicineList(
            listOf(
                MedicineListObject(1, "8:00AM"),
                MedicineListObject(5, "9:00AM"),
                MedicineListObject(11, "10:00AM"),
                MedicineListObject(26, "11:00AM"),
                MedicineListObject(27, "12:00AM"),
                MedicineListObject(29, "5:00PM"),
                MedicineListObject(35, "6:00PM"),
                MedicineListObject(46, "7:30PM"),
                MedicineListObject(50, "8:00PM")
            )
        )

        viewModel.state.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, it.toString())
            listener!!.onCreateAccountClicked()
        })

        adapter.setOnItemClickListener(object : MedicineListAdapter.OnItemClickListener {
            override fun onClick(pos: Int) {
                Log.i(TAG, "Adapter pos: $pos")

                // Get the DB ID of a particular medicine item
                val medicineID = adapter.getMedicineAt(pos).ID
                Log.i(TAG, "DB ID: $medicineID")

                viewModel.setMedicineDetailsDatabaseID(medicineID)
            }
        })
    }

}
