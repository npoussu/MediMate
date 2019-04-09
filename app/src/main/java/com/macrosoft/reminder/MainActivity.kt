package com.macrosoft.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "database"
//        ).allowMainThreadQueries().build()
//
//        val user = User(1, "Joe Bob", "1234", "Joe")
//        val med = MedicineData(1, 1,"Pill", "A pill")
//        val med2 = MedicineData(2, 1,"Pill 2", "A pill 2")
//
//        db.userDao().delete(user)
//        db.userDao().insert(user)
//        db.medicineDataDAO().insert(med)
//        db.medicineDataDAO().insert(med2)
//
//        val users = db.userDao().getUserByName(user.userName)
//
//        Log.d("MainTag", users.toString())
    }
}
