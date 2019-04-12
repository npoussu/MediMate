package com.macrosoft.reminder.view.ui.loggedout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.macrosoft.reminder.R
import com.macrosoft.reminder.databinding.FragmentCreateUserBinding
import com.macrosoft.reminder.viewmodel.CreateAccountViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CreateAccountFragment : Fragment() {

    private val viewModel: CreateAccountViewModel by viewModel()

    lateinit var binding: FragmentCreateUserBinding

    var listener: OnAccExistsClickedListener? = null

    interface OnAccExistsClickedListener {
        fun onAccExistsClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnAccExistsClickedListener
        if (listener == null) {
            throw ClassCastException("$context must implement OnAccExistsClickedListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_user, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.showLoginFragment.observe(this, Observer {
            listener!!.onAccExistsClicked()
        })
    }

}