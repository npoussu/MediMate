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

    fun getUserByID(id: Int): LiveData<User> {
        return userDAOImpl.getUserByID(id)
    }

    fun deleteUser(user: User) {
        return userDAOImpl.delete(user)
    }

    fun insertUser(user: User) {
        return userDAOImpl.insert(user)
    }

    fun updateUser(user: User) {
        return userDAOImpl.update(user)
    }
}

