package com.macrosoft.reminder.view.ui.loggedin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val service = Intent(context, NotificationService::class.java)
        service.putExtra("timestamp", intent?.getLongExtra("timestamp", 0))
        service.putExtra("medicineName", intent?.getStringExtra("medicineName"))
        service.putExtra("dosageValue", intent?.getStringExtra("dosageValue"))
        service.putExtra("requirementsValue", intent?.getStringExtra("requirementsValue"))
        service.putExtra("useRTC", intent?.getBooleanExtra("useRTC", false))
        context?.startService(service)
    }
}