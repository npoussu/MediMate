package com.macrosoft.reminder.view.ui.loggedin

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import java.util.*


class NotificationUtils {

    fun setNotification(
        medicine: String,
        dosage: String,
        requirements: String,
        timeInMilliSeconds: Long,
        activity: FragmentActivity
    ) {

        if (timeInMilliSeconds > 0) {

            val alarmManager = activity.getSystemService(Activity.ALARM_SERVICE) as AlarmManager
            val alarmIntent = Intent(activity.applicationContext, AlarmReceiver::class.java)

            alarmIntent.putExtra("timestamp", timeInMilliSeconds)
            alarmIntent.putExtra("medicineName", medicine)
            alarmIntent.putExtra("dosageValue", dosage)
            alarmIntent.putExtra("requirementsValue", requirements)

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMilliSeconds

            val pendingIntent = PendingIntent.getBroadcast(activity, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT)
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        }
    }
}