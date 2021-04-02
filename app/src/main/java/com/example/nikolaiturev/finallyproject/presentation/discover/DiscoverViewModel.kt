package com.example.nikolaiturev.finallyproject.presentation.discover

import com.example.nikolaiturev.finallyproject.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class DiscoverViewModel(private val auth: FirebaseAuth) : BaseViewModel() {

    fun singOutFirebaseAuth() {
        auth.signOut()
        navController.navigateUp()
    }
}
