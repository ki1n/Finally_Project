package com.example.nikolaiturev.finallyproject.di

import com.example.nikolaiturev.finallyproject.presentation.action_choice_dialog.ActionChoicePhotoViewModel
import com.example.nikolaiturev.finallyproject.presentation.gallery_photo.PhotoGalleryViewModel
import com.example.nikolaiturev.finallyproject.presentation.gallery_photo_details.GalleryPhotoDetailsViewModel
import com.example.nikolaiturev.finallyproject.presentation.log_in.LoginViewModel
import com.example.nikolaiturev.finallyproject.presentation.map.MapViewModel
import com.example.nikolaiturev.finallyproject.presentation.register.RegisterViewModel
import com.example.nikolaiturev.finallyproject.presentation.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { RegisterViewModel(get()) }

    viewModel { LoginViewModel(get()) }

    viewModel { WelcomeViewModel(get()) }

    viewModel { PhotoGalleryViewModel(get()) }

    viewModel { ActionChoicePhotoViewModel(get()) }

    viewModel { MapViewModel() }

    viewModel { GalleryPhotoDetailsViewModel(get()) }
}
