package com.example.doh.di

import androidx.room.Room
import com.example.doh.db.MsgDB
import com.example.doh.viewmodels.HomeFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module


import org.koin.dsl.module

val database = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            MsgDB::class.java,
            "msg_db"
        ).build()
    }
}

val viewModels = module {
    viewModel{HomeFragmentViewModel()}
}

val applicationModules:List<Module> = listOf(
    viewModels
)