package com.example.nikolaiturev.finallyproject.di

import androidx.room.Room
import com.example.nikolaiturev.finallyproject.data.dao.FinallyProjectDatabase
import com.example.nikolaiturev.finallyproject.util.DatabaseConst
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), FinallyProjectDatabase::class.java, DatabaseConst.DATABASE_NAME)
            .build()
    }

    single { get<FinallyProjectDatabase>().finallyProjectDao() }
}
