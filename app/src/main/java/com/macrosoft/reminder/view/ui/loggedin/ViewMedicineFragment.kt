package com.macrosoft.reminder.view.ui.loggedin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.data.MedicineListAdapter
import com.macrosoft.reminder.model.MedicineListObject
import kotlinx.android.synthetic.main.view_medicine_fragment.*


/**
 * ViewMedicineFragment: Main screen of the application. Displays a list of card representing medicine to be taken at
 * certain times
 *
 */
class ViewMedicineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_medicine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        medicineList_main.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        // Initialize adapter for the RecyclerView with some sample data
        val adapter = MedicineListAdapter(
            context!!, listOf(
                MedicineListObject("8:00AM", listOf("Alpha E", "Razadyne", "Donepezil", "Vitamin E")),
                MedicineListObject("9:00AM", listOf("Alpha E", "Hydergine", "Donepezil", "Etanercept")),
                MedicineListObject("10:00AM", listOf("Alpha E", "Aquasol E", "Donepezil", "Etanercept")),
                MedicineListObject("11:00AM", listOf("Alpha E", "Razadyne", "Donepezil", "Vitamin E")),
                MedicineListObject("12:00AM", listOf("Alpha E", "Hydergine", "Donepezil", "Etanercept")),
                MedicineListObject("5:00PM", listOf("Alpha E", "Aquasol E", "Donepezil", "Etanercept")),
                MedicineListObject("6:00PM", listOf("Alpha E", "Razadyne", "Donepezil", "Vitamin E")),
                MedicineListObject("7:30PM", listOf("Alpha E", "Hydergine", "Donepezil", "Etanercept")),
                MedicineListObject("8:00PM", listOf("Alpha E", "Aquasol E", "Donepezil", "Etanercept"))
            )
        )

        medicineList_main.adapter = adapter

    }
}
