package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity(), ViewMedicineFragment.OnMedicineCardClickedListener {

    override fun onCreateAccountClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        toolbar_title.text = getString(R.string.my_medicines_title)

        with(ft) {
            replace(R.id.fragment_holder, ViewMedicineDetailsFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbar_title.text = getString(R.string.my_medicines_title)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, ViewMedicineFragment())
            commit()
        }
    }
}
