package com.example.nikolaiturev.finallyproject.presentation.gallery_photo_details

import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.presentation.base.BaseFragment
import com.example.nikolaiturev.finallyproject.presentation.gallery_photo_details.adapter.PhotoDetailsAdapter
import kotlinx.android.synthetic.main.fragment_gallery_photo_details.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryPhotoDetailsFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_gallery_photo_details

    override val viewModel by viewModel<GalleryPhotoDetailsViewModel>()

    private val photoDetailsAdapter by inject<PhotoDetailsAdapter>()

   var position: Int = 0

    override fun initView() {
        baseSubscribe(viewModel)
        initAdapter()

        viewModel.listImageLiveData.observe(viewLifecycleOwner, { list ->
            photoDetailsAdapter.submitList(list)
        //    view_pager.setCurrentItem( view_pager.childCount *  Variables.A_BIG_NUMBER / 2, false)
         //   photoDetailsAdapter.notifyDataSetChanged()
        })
    }

    private fun initAdapter() {
        view_pager.adapter = photoDetailsAdapter

        photoDetailsAdapter.onClickListener = {
            position = it
        }
    }
}
