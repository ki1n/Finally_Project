package com.example.nikolaiturev.finallyproject.presentation.discover

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_discover.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiscoverFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_discover

    override val viewModel by viewModel<DiscoverViewModel>()

    override fun initView() {
        bottom_navigation_view.itemIconTintList = null
        val navHost = childFragmentManager.findFragmentById(R.id.fragment_discover) as NavHostFragment
        bottom_navigation_view.setupWithNavController(navHost.navController)
    }
}
