package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
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

    val showToast = LiveEvent<String>()

    fun onCreateAccountClick() {
        val databaseUser: LiveData<User> = repo.getUserByName(userIdContent.value.toString())

        Log.i(TAG, databaseUser.value.toString())

        if (databaseUser.value != null) { // If user already exists
            onAccountExists()
        }
        else { // Input new user into db
            onCreateNewAccount()
        }
    }

    private fun onCreateNewAccount() {
        val inputUserName = userIdContent.value.toString()
        val inputPassword = passwordContent.value.toString()
        val inputRepeatPassword = repeatPasswordContent.value.toString()

        if (inputPassword != inputRepeatPassword) { // If both passwords not match
            showToast.value = "Password do not match"
        }
        else {
            val user = User(userPassword = inputPassword, userName = inputUserName, id = 0, displayName = "Mary")
            repo.insertUser(user)
            showToast.value = "Account Created"
            showLoginFragment.value = true
        }
    }

    private fun onAccountExists() {
        showToast.value = "Account Already Exist!"
        Log.i(TAG, "Account Exists")
    }

    fun onShowLoginClick() {
        showLoginFragment.value = true
    }
}