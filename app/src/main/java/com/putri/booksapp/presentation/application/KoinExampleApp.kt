package com.putri.booksapp.presentation.application

import android.app.Application
import com.putri.booksapp.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// membuat class KoinExampleApp yang mengextends dari class Applicatiom
class KoinExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // memulai Koin pada class KoinApplication.
        startKoin {
            androidContext(this@KoinExampleApp)
            // modules
            modules(appModule)

            fileProperties()
        }
    }
}