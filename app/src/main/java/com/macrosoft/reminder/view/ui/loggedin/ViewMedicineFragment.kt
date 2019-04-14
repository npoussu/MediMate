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
import com.macrosoft.reminder.model.MedicineNameObject
import com.macrosoft.reminder.model.MedicineTimeObject
import com.macrosoft.reminder.model.NestedMedicineNameObjectWrapper
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

        val adapter = MedicineListAdapter()

        adapter.setData(
            listOf(
                MedicineTimeObject("4:20AM"),
                NestedMedicineNameObjectWrapper(
                    listOf(
                        MedicineNameObject("Paracetamol"),
                        MedicineNameObject("Dope"),
                        MedicineNameObject("LSD")
                    )
                ),
                MedicineTimeObject("5:00AM"),
                NestedMedicineNameObjectWrapper(
                    listOf(
                        MedicineNameObject("Huume"),
                        MedicineNameObject("Piri"),
                        MedicineNameObject("Kusi")
                    )
                )
            )
        )

        medicineList.adapter = adapter

    }
}
