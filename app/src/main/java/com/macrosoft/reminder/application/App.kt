package com.macrosoft.reminder.application

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Modules.init()
    }
}