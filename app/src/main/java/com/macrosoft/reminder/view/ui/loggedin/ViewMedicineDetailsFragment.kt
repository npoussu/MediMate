package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.macrosoft.reminder.R
import com.macrosoft.reminder.data.MedicineDetailsAdapter
import com.macrosoft.reminder.model.MedicineCardItemDetailed
import kotlinx.android.synthetic.main.view_medicine_fragment.*

class ViewMedicineDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        medicineList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        val adapter = MedicineDetailsAdapter(
            listOf(
                MedicineCardItemDetailed("Paracetamol", "8:00AM", "5 pills", "-"),
                MedicineCardItemDetailed("Paracetamol", "8:00AM", "5 pills", "-"),
                MedicineCardItemDetailed("Paracetamol", "8:00AM", "5 pills", "-"),
                MedicineCardItemDetailed("Paracetamol", "8:00AM", "5 pills", "-")
            )
        )

        medicineList.adapter = adapter

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_medicine_fragment, container, false)
    }
}
