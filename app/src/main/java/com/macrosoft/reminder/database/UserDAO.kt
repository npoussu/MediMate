package com.macrosoft.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.macrosoft.reminder.model.User

@Dao
interface UserDAO: BaseDao<User>{
    @Query("SELECT * FROM users where user_name = :userName")
    fun getUserByName(userName : String): User

    @Query("SELECT * FROM users where id = :id")
    fun getUserByID(id : Int): LiveData<User>

}
