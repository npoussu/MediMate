package com.macrosoft.reminder.viewmodel

import android.util.Log
import android.widget.Toast
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

    val showOnAccountExistsToast = LiveEvent<Boolean>()
    val showNotMatchPasswordToast = LiveEvent<Boolean>()
    val showOnAccountCreatedToast = LiveEvent<Boolean>()

    fun onCreateAccountClick() {
        val databaseUser: LiveData<User> = repo.getUserByName(userIdContent.value.toString())

        Log.i(TAG, databaseUser.value.toString())

        if (databaseUser.value != null) { // If user already exists
            onAccountExistsClick()
        }
        else { // Input new user into db
            onNewAccountClick()
        }
    }

    fun onNewAccountClick() {

        if(passwordContent.value.toString() != repeatPasswordContent.value.toString()) { // If both passwords not match
            showNotMatchPasswordToast.value = true
        }
        else {
            val user = User(userPassword = passwordContent.value.toString(), userName = userIdContent.value.toString(), id = 0, displayName = "Mary")
            repo.insertUser(user)
            showOnAccountCreatedToast.value = true
            showLoginFragment.value = true
        }
    }

    fun onAccountExistsClick() {
        showOnAccountExistsToast.value = true
        Log.i(TAG, "Account Exists")
    }

}