package com.macrosoft.reminder.application

import androidx.room.Room
import com.macrosoft.reminder.database.AppDatabase
import com.macrosoft.reminder.repository.UserRepository
import com.macrosoft.reminder.viewmodel.AddMedicineViewModel
import com.macrosoft.reminder.viewmodel.CreateAccountViewModel
import com.macrosoft.reminder.viewmodel.LoginViewModel
import com.macrosoft.reminder.viewmodel.ViewMedicineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {

    val viewModelModule = module(override = true) {
        viewModel { LoginViewModel(get()) }
        viewModel { CreateAccountViewModel(get()) }
        viewModel { ViewMedicineViewModel() }
        viewModel { AddMedicineViewModel() }
    }

    val repositoryModule = module(override = true) {
        // Declare Repository dependencies here
        single { UserRepository(get()) }

    }

    val databaseModule = module(override = true) {
        single {
            Room.databaseBuilder(
                get(),
                AppDatabase::class.java,
                "reminder"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration() // On migration destroy DB
                .build()
        }
    }

    val daoModule = module(override = true) {
        // Declare DAO dependencies here
        single { get<AppDatabase>().userDao() }

    }
}