package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity(), ViewMedicineFragment.OnMedicineCardClickedListener {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

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

        // Get the userID from Intent extras, will be used to fetch data for a particular user from DB
        val userID = intent.getIntExtra("userID", 0)
        val userDisplayName = intent.getStringExtra("userDisplayName")

        Log.i(TAG, "UserDisplayName: $userDisplayName, ID: $userID")
    }
}
