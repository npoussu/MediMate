package com.macrosoft.reminder.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {
    @Insert
    fun insert(data: T): Long

    @Delete
    fun delete(data: T)

    @Update
    fun update(data: T)
}
