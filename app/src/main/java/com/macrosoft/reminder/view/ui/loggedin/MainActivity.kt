package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity(), ViewMedicineFragment.OnMedicineCardClickedListener,
    ViewMedicineDetailsFragment.OnDetailedListCardClickedListener, EditMedicineFragment.OnPopBackStack,
    AddMedicineFragment.OnPopBackStack, AddScheduleFragment.IAddScheduleFragment,
    EditScheduleFragment.IEditScheduleFragment {

    private var takeMedicine = false

    override fun onEditScheduleClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        with(ft) {
            replace(R.id.fragment_holder, EditScheduleFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onAddScheduleClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        with(ft) {
            replace(R.id.fragment_holder, AddScheduleFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onAddReminderClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        with(ft) {
            replace(R.id.fragment_holder, AddMedicineFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun setToolbarTitle(title: String) {
        toolbar_title.text = title
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onResume() {
        super.onResume()

        takeMedicine = intent.getBooleanExtra("takeMedicine", false)
        val medicineName = intent.getStringExtra("medicineName")
        val dosageValue = intent.getStringExtra("dosageValue")
        val requirementsValue = intent.getStringExtra("requirementsValue")

        if (takeMedicine && medicineName != null) {
            // Initialize a new instance of
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Reminder")
            builder.setMessage("Take medicine: $medicineName\nDosage: $dosageValue\nRequirements: $requirementsValue")

            builder.setPositiveButton("Taken") { dialog, which ->

            }

            builder.setNegativeButton("Cancel") { dialog, which ->
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
            takeMedicine = false
        }

    }

    override fun onDetailedListCardClick() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        with(ft) {
            replace(R.id.fragment_holder, EditMedicineFragment())
            addToBackStack(null)
            commit()
        }
    }

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

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Get the userID from Intent extras, will be used to fetch data for a particular user from DB
        val userID = intent.getIntExtra("userID", 0)
        val userDisplayName = intent.getStringExtra("userDisplayName")

        Log.i(TAG, "UserDisplayName: $userDisplayName, ID: $userID")

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, ViewMedicineFragment(userID))
            commit()
        }


    }
}
