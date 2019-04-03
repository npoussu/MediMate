package com.macrosoft.reminder.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.macrosoft.reminder.model.Schedule
import com.macrosoft.reminder.model.User

@Database(entities = [(User::class), (Schedule::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun scheduleDao(): ScheduleDAO
}