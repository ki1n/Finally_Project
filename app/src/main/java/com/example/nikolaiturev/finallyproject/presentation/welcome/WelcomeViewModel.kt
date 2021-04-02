package com.example.nikolaiturev.finallyproject.presentation.welcome

import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class WelcomeViewModel(private val auth: FirebaseAuth) : BaseViewModel() {

    // TODO точно GET current user?
    fun getCurrentUser() {
        if (auth.currentUser != null) {
            navigateTo(R.id.action_welcomeFragment_to_discoverFragment)
        }
    }

    fun navigateToLogin() {
        navigateTo(R.id.action_welcomeFragment_to_loginFragment)
    }

    fun navigateToRegister() {
        navigateTo(R.id.action_welcomeFragment_to_registerFragment)
    }
}
