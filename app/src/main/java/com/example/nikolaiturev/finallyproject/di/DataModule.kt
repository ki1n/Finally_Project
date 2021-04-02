package com.example.nikolaiturev.finallyproject.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val dataModule = module {

    single { FirebaseAuth.getInstance() }
}

