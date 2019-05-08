package com.macrosoft.reminder.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.macrosoft.reminder.model.MedicineData
import com.macrosoft.reminder.model.Reminder
import com.macrosoft.reminder.model.Schedule
import com.macrosoft.reminder.model.User

@Database(
    entities = [(User::class), (Schedule::class), (MedicineData::class), (Reminder::class)],
    version = 4,
    exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun scheduleDao(): ScheduleDAO
    abstract fun reminderDAO(): ReminderDAO
    abstract fun medicineDataDAO(): MedicineDataDAO
}