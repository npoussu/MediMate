package com.macrosoft.reminder.application

import org.koin.dsl.module.module

object AppModules {

    val viewModelModule = module(override = true) {
        // Declare ViewModel dependencies here
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