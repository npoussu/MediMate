package com.macrosoft.reminder.view.ui.loggedout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.macrosoft.reminder.R
import kotlinx.android.synthetic.main.toolbar_main.*

class StartActivity : AppCompatActivity(),
    LoginFragment.OnCreateAccountClickedListener,
    CreateAccountFragment.OnAccExistsClickedListener {

    override fun setToolbarTitle(title: String) {
        toolbar_title.text = title
    }

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {

                toolbar_title.text = getString(R.string.faq_title)

                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                with(ft) {
                    replace(R.id.fragment_holder, FaqFragment())
                    addToBackStack(null)
                    commit()
                }


                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }


    }

}
