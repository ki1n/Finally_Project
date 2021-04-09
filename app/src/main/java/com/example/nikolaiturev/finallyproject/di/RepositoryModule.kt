package com.example.nikolaiturev.finallyproject.di

import com.example.nikolaiturev.finallyproject.data.photo.PhotoRepositoryImpl
import com.example.nikolaiturev.finallyproject.domain.repository.PhotoRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<PhotoRepository> { PhotoRepositoryImpl(get()) }
}
