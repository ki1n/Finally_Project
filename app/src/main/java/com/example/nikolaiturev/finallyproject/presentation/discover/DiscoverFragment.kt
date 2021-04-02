package com.example.nikolaiturev.finallyproject.presentation.discover

import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.finallyproject.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_discover.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiscoverFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_discover

    override val viewModel by viewModel<DiscoverViewModel>()

    override fun initView() {

        // TODO создал для теста
        button_signOut.setOnDebouncedClickListener {
            viewModel.singOutFirebaseAuth()
        }
    }
}
