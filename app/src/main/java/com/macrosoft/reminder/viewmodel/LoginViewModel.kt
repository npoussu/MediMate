package com.macrosoft.reminder.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.macrosoft.reminder.model.User
//import com.macrosoft.reminder.repository.FakeRepository
import com.macrosoft.reminder.repository.UserRepository

/**
 * LoginViewModel: Holds the references to Data Binded fields at LoginFragment
 * Handles authenticating the user
 */

class LoginViewModel(private val repo: UserRepository) : ObservableViewModel() {

    private val TAG = LoginViewModel::class.java.simpleName

    // Data binded fields at fragment_login.xml
    @Bindable
    val userIdContent = MutableLiveData<String>()

    @Bindable
    val passwordContent = MutableLiveData<String>()

    val createAccountClickedState = LiveEvent<Boolean>()

    val onLoginSuccess = LiveEvent<User>()

//    private val fakeUser: LiveData<User>
//        get() = FakeRepository.fakeUser

    // TODO: Add the user authentication function here
    fun onLoginClick() {
        Log.i(TAG, "UserID: " + userIdContent.value)
        Log.i(TAG, "Password: " + passwordContent.value)

        val userName = userIdContent.value.toString()
        val userPassword = passwordContent.value.toString()

        val databaseUser: LiveData<User>
        databaseUser = repo.getUserByName(userName)


        if(databaseUser.value!!.userPassword != userPassword) {
            // Only set this if credentials are valid, triggers transaction to MainActivity
            onLoginSuccess.value = databaseUser.value
        }




    }

    fun onCreateAccountClick() {
        createAccountClickedState.value = true
    }

}