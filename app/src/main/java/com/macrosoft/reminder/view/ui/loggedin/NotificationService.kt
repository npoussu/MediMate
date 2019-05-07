package com.macrosoft.reminder.view.ui.loggedin

import android.app.IntentService
import android.content.Intent
import java.util.*

class NotificationService : IntentService("NotificationService") {

    override fun onHandleIntent(intent: Intent?) {

        var timestamp: Long = 0
        var medicineName = "X"
        var dosage = "0 pills"
        var requirements = "-"
        var useRTC = false

        if (!(intent == null || intent.extras == null)) {
            timestamp = intent.extras!!.getLong("timestamp")
            medicineName = intent.extras!!.getString("medicineName")
            dosage = intent.extras!!.getString("dosageValue")
            requirements = intent.extras!!.getString("requirementsValue")
            useRTC = intent.extras!!.getBoolean("useRTC")
        }

        if (timestamp > 0 || useRTC) {

            val notifyIntent = Intent(this, MainActivity::class.java)

            notifyIntent.putExtra("takeMedicine", true)
            notifyIntent.putExtra("medicineName", medicineName)
            notifyIntent.putExtra("dosageValue", dosage)
            notifyIntent.putExtra("requirementsValue", requirements)


            notifyIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timestamp

            startActivity(notifyIntent)

        }

    }
}