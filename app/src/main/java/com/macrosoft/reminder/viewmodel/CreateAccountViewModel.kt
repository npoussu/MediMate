package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent

class CreateAccountViewModel : ObservableViewModel() {

    private val TAG = CreateAccountViewModel::class.java.simpleName

    // Data binded fields at fragment_create_user.xml
    @Bindable
    val userIdContent = MutableLiveData<String>()

    @Bindable
    val passwordContent = MutableLiveData<String>()

    @Bindable
    val repeatPasswordContent = MutableLiveData<String>()

    val showLoginFragment = LiveEvent<Boolean>()

    fun onCreateAccountClick() {
        Log.i(TAG, "UserID: " + userIdContent.value)
        Log.i(TAG, "Password: " + passwordContent.value)
        Log.i(TAG, "Repeat Password: " + repeatPasswordContent.value)
    }

    fun onAccountExistsClick() {
        showLoginFragment.value = true
    }

}