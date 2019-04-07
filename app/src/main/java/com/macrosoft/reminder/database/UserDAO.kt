package com.macrosoft.reminder.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.macrosoft.reminder.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users where user_name = :userName")
    fun getUserByName(userName : String): User

    @Insert
    fun insert(users: User)

    @Delete
    fun delete(user: User)
}