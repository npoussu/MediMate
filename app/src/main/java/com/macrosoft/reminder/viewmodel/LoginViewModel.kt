package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.macrosoft.reminder.model.User
import com.macrosoft.reminder.repository.FakeLoginRepository

/**
 * LoginViewModel: Holds the references to Data Binded fields at LoginFragment
 * Handles authenticating the user
 */

class LoginViewModel : ObservableViewModel() {

    private val TAG = LoginViewModel::class.java.simpleName

    // Data binded fields at fragment_login.xml
    @Bindable
    val userIdContent = MutableLiveData<String>()

    @Bindable
    val passwordContent = MutableLiveData<String>()

    val fakeUser: LiveData<User>
        get() = FakeLoginRepository.fakeUser

    // TODO: Add the user authentication function here
    fun onLoginClick() {
        Log.i(TAG, userIdContent.value)
        Log.i(TAG, passwordContent.value)
    }

}