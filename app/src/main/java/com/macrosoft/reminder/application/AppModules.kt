package com.macrosoft.reminder.application

import com.macrosoft.reminder.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object AppModules {

    val viewModelModule = module(override = true) {
        viewModel { LoginViewModel() }
    }

    val repositoryModule = module(override = true) {
        // Declare Repository dependencies here
    }

    val databaseModule = module(override = true) {
        /*single {
            Room.databaseBuilder(
                get(),
                DATABASENAME::class.java,
                "TABLE_NAMES_HERE")
                .fallbackToDestructiveMigration() // On migration destroy DB
                .build()
        }*/
    }

    val daoModule = module(override = true) {
        // Declare DAO dependencies here
    }
}