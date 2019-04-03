package com.macrosoft.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.macrosoft.reminder.database.AppDatabase
import com.macrosoft.reminder.model.Schedule
import com.macrosoft.reminder.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "database"
//        ).allowMainThreadQueries().build()
//
//        val user = User(1, "Joe Bob", "1234", "Joe")
//        val schedule = Schedule(1, 1554308148262, 1554308148262, false)
//
//        db.userDao().delete(user)
//        db.userDao().insert(user)
//        db.scheduleDao().insert(schedule)
//        val users = db.userDao().getFirst()
//
//        val s = db.scheduleDao().get(1)
//
//        Log.d("MainTag", users.displayName)
//        Log.d("MainTag", s.startDate.toString())
    }
}
