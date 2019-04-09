package com.macrosoft.reminder.view.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.FragmentLoginBinding
import com.macrosoft.reminder.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModel()

    lateinit var binding: FragmentLoginBinding

    var listener: OnCreateAccountClickedListener? = null

    interface OnCreateAccountClickedListener {
        fun onCreateAccountClicked()
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
        viewModel.createAccountClickedState.observe(this, Observer {
            listener!!.onCreateAccountClicked()
        })
    }

}