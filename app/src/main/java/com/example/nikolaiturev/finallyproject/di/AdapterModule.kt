package com.example.nikolaiturev.finallyproject.di

import com.example.nikolaiturev.finallyproject.presentation.gallery_photo.adapter.PhotoAdapter
import com.example.nikolaiturev.finallyproject.presentation.gallery_photo_details.adapter.PhotoDetailsAdapter
import org.koin.dsl.module

val adapterModule = module {

    single { PhotoAdapter() }

    single { PhotoDetailsAdapter() }
}
