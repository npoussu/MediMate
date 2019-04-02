package com.macrosoft.reminder.application

import com.macrosoft.reminder.application.AppModules.daoModule
import com.macrosoft.reminder.application.AppModules.databaseModule
import com.macrosoft.reminder.application.AppModules.repositoryModule
import com.macrosoft.reminder.application.AppModules.viewModelModule
import org.koin.standalone.StandAloneContext.loadKoinModules

/**
 * Modules: Singleton instance that initializes the Dependency Injection modules
 */

object Modules {
    fun init() = loadKoinModules(
        viewModelModule, repositoryModule,
        databaseModule, daoModule
    )
}