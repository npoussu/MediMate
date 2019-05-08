package com.macrosoft.reminder.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.macrosoft.reminder.database.UserDAO
import com.macrosoft.reminder.model.User

class UserRepository(userDAO: UserDAO) {

    private val userDAOImpl: UserDAO = userDAO

    fun getUserByName(name: String): LiveData<User> {
        val userLiveData = MutableLiveData<User>()
        userLiveData.value = userDAOImpl.getUserByName(name)
        return userLiveData
    }
    fun insertUser(user: User): Long {
        return userDAOImpl.insert(user)
    }
}

