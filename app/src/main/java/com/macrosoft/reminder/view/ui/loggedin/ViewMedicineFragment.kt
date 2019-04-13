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
import com.macrosoft.reminder.model.MedicineListData
import kotlinx.android.synthetic.main.view_medicine_fragment.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ViewMedicineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_medicine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        medicineList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        val adapter = MedicineListAdapter(
            listOf(
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope"),
                MedicineListData("4:20AM", "Dope")
            )
        )

        medicineList.adapter = adapter

    }
}
