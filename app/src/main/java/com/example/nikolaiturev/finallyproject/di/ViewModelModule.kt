package com.example.nikolaiturev.finallyproject.di

import com.example.nikolaiturev.finallyproject.presentation.discover.DiscoverViewModel
import com.example.nikolaiturev.finallyproject.presentation.log_in.LoginViewModel
import com.example.nikolaiturev.finallyproject.presentation.register.RegisterViewModel
import com.example.nikolaiturev.finallyproject.presentation.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { RegisterViewModel(get()) }

    viewModel { LoginViewModel(get()) }

    viewModel { WelcomeViewModel(get()) }

    viewModel { DiscoverViewModel(get()) }
}
