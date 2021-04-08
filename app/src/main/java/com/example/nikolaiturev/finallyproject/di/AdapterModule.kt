package com.example.nikolaiturev.finallyproject.di

import com.example.nikolaiturev.finallyproject.presentation.gallery_photo.adapter.PhotoAdapter
import org.koin.dsl.module

val adapterModule = module {

    single { PhotoAdapter() }
}
