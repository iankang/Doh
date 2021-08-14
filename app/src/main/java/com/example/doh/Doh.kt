package com.example.doh

import android.app.Application
import android.util.Log
import com.example.doh.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.module.Module


class Doh:Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        try {
            startKoin {
                androidLogger(Level.DEBUG)
                androidContext(this@Doh)
            val modules = mutableListOf<Module>().apply {
                addAll(applicationModules)
            }
                modules(modules)
            }
        }catch (error:KoinAppAlreadyStartedException){
            Log.e("Application",error.localizedMessage)
        }
    }
}