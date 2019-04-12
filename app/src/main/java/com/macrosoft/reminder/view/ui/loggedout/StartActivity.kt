package com.macrosoft.reminder.view.ui.loggedout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R

class StartActivity : AppCompatActivity(),
    LoginFragment.OnCreateAccountClickedListener,
    CreateAccountFragment.OnAccExistsClickedListener {

    override fun onCreateAccountClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, CreateAccountFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onAccExistsClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, LoginFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, LoginFragment())
            commit()
        }
    }
}
