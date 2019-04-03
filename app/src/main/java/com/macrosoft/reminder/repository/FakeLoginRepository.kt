package com.macrosoft.reminder.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.macrosoft.reminder.model.User

object FakeLoginRepository {

    private val _fakeUser = MutableLiveData<User>()

    init {
        _fakeUser.value = User("mary", "maryodriscoll", "password123")
    }

    val fakeUser: LiveData<User>
        get() = _fakeUser

}