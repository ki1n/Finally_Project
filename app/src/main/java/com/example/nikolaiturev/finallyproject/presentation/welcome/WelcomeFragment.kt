package com.example.nikolaiturev.finallyproject.presentation.welcome

import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.finallyproject.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_welcome.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_welcome

    override val viewModel by viewModel<WelcomeViewModel>()

    override fun initView() {
        // TODO что возвращает getCurrentUser?
        viewModel.getCurrentUser()

        button_welcome_login.setOnDebouncedClickListener {
            viewModel.navigateToLogin()
        }

        button_welcome_register.setOnDebouncedClickListener {
            viewModel.navigateToRegister()
        }
    }
}
