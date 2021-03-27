package com.example.nikolaiturev.finallyproject

import android.app.Application
import com.example.nikolaiturev.finallyproject.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FinallyProjectApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            this.modules(
                listOf(
                    dataModule,
                    repositoryModule,
                    viewModelModule,
                    mapperModule,
                    adapterModule
                )
            )
            this.androidContext(this@FinallyProjectApp)
        }
    }
}
