package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.macrosoft.reminder.model.User
import com.macrosoft.reminder.repository.UserRepository

class CreateAccountViewModel(private val repo: UserRepository) : ObservableViewModel() {

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

        val user = User(userPassword = passwordContent.value.toString(), userName = userIdContent.value.toString(), id = 0, displayName = "Mary")
//        repo.insertUser(user)
        Log.i(TAG, user.userName + " : " + user.userPassword)

        showLoginFragment.value = true
    }

    fun onAccountExistsClick() {
        showLoginFragment.value = true
    }

}