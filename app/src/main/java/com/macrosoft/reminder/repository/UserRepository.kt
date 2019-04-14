package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import com.macrosoft.reminder.database.UserDAO
import com.macrosoft.reminder.model.User

class UserRepository(userDAO: UserDAO) {

    private val userDAOImpl: UserDAO = userDAO

    fun getUserByName(name: String): LiveData<User> {
        return userDAOImpl.getUserByName(name)
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

