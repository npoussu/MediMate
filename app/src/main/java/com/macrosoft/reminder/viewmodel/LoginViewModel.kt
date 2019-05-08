package com.macrosoft.reminder.viewmodel

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

    val showToast = LiveEvent<String>()

    fun onLoginClick() {
        val userName = userIdContent.value.toString()
        val userPassword = passwordContent.value.toString()

        val databaseUser: LiveData<User> = repo.getUserByName(userName)

        if(userName.isBlank()) {
            showToast.value = "Please Enter User Name"
        }
        else if(userPassword.isBlank()) {
            showToast.value = "Please Enter Password Name"
        }
        else if (databaseUser.value == null) { // User Don't exist
            showToast.value = "User does not exist!"
        } else if (databaseUser.value!!.userPassword != userPassword) { // Exists but wrong password
            showToast.value = "Incorrect Password"
        } else { // Login Success
            showToast.value = "Login Success!"
            onLoginSuccess.value = databaseUser.value
        }
    }

    fun onCreateAccountClick() {
        createAccountClickedState.value = true
    }

}