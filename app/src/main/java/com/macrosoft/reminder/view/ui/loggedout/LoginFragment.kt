package com.macrosoft.reminder.view.ui.loggedout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.FragmentLoginBinding
import com.macrosoft.reminder.view.ui.loggedin.MainActivity
import com.macrosoft.reminder.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModel()

    lateinit var binding: FragmentLoginBinding

    var listener: OnCreateAccountClickedListener? = null

    interface OnCreateAccountClickedListener {
        fun onCreateAccountClicked()
        fun setToolbarTitle(title: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnCreateAccountClickedListener
        if (listener == null) {
            throw ClassCastException("$context must implement OnCreateAccountClickedListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        listener?.setToolbarTitle(getString(R.string.login_title))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.createAccountClickedState.observe(this, Observer {
            listener!!.onCreateAccountClicked()
        })

        viewModel.onLoginSuccess.observe(this, Observer {
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("userID", it.id)
            intent.putExtra("userDisplayName", it.displayName)
            startActivity(intent)
        })

        viewModel.showToast.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }
}