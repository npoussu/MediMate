package com.macrosoft.reminder.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                AppModules.daoModule,
                AppModules.databaseModule,
                AppModules.repositoryModule,
                AppModules.viewModelModule
            )
        }
    }
}