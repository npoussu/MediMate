package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R

class MainActivity : AppCompatActivity(), ViewMedicineFragment.OnMedicineCardClickedListener {

    override fun onCreateAccountClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, ViewMedicineDetailsFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, ViewMedicineFragment())
            commit()
        }
    }
}
