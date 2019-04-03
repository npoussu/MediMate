package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.macrosoft.reminder.model.User
import com.macrosoft.reminder.repository.FakeLoginRepository

class LoginViewModel : ObservableViewModel() {

    private val TAG = LoginViewModel::class.java.simpleName

    @Bindable
    val userIdContent = MutableLiveData<String>()

    @Bindable
    val passwordContent = MutableLiveData<String>()

    val fakeUser: LiveData<User>
        get() = FakeLoginRepository.fakeUser

    fun onLoginClick() {
        Log.i(TAG, userIdContent.value)
        Log.i(TAG, passwordContent.value)
    }

}