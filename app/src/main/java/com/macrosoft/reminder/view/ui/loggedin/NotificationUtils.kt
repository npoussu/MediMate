package com.macrosoft.reminder.view.ui.loggedin

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentActivity
import java.util.*


class NotificationUtils {

    companion object {
        private val TAG = NotificationUtils::class.java.simpleName
    }

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

    fun setNotificationRTC(
        useRTC: Boolean,
        medicine: String,
        dosage: String,
        requirements: String,
        timeInRTCHour: Int,
        timeInRTCMinute: Int,
        activity: FragmentActivity
    ) {

        Log.i(TAG, timeInRTCHour.toString())
        Log.i(TAG, timeInRTCMinute.toString())

        val alarmManager = activity.getSystemService(Activity.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(activity.applicationContext, AlarmReceiver::class.java)

        alarmIntent.putExtra("medicineName", medicine)
        alarmIntent.putExtra("dosageValue", dosage)
        alarmIntent.putExtra("requirementsValue", requirements)
        alarmIntent.putExtra("useRTC", useRTC)

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, timeInRTCHour)
        calendar.set(Calendar.MINUTE, timeInRTCMinute)
        calendar.set(Calendar.SECOND, 0)

        val pendingIntent = PendingIntent.getBroadcast(activity, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

    }
}
