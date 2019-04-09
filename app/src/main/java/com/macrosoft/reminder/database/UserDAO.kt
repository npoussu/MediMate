package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.macrosoft.reminder.model.User

@Dao
interface UserDAO : BaseDao<User>{
    @Query("SELECT * FROM users where user_name = :userName")
    fun getUserByName(userName : String): LiveData<User>
}