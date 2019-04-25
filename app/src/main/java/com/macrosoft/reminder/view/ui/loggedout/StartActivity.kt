package com.macrosoft.reminder.view.ui.loggedout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R
import kotlinx.android.synthetic.main.toolbar_main.*

class StartActivity : AppCompatActivity(),
    LoginFragment.OnCreateAccountClickedListener,
    CreateAccountFragment.OnAccExistsClickedListener {

    override fun onCreateAccountClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        toolbar_title.text = getString(R.string.create_account_title)

        with(ft) {
            replace(R.id.fragment_holder, CreateAccountFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onAccExistsClicked() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        toolbar_title.text = getString(R.string.login_title)

        with(ft) {
            replace(R.id.fragment_holder, LoginFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toolbar_title.text = getString(R.string.login_title)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        with(ft) {
            replace(R.id.fragment_holder, LoginFragment())
            commit()
        }
    }
}
