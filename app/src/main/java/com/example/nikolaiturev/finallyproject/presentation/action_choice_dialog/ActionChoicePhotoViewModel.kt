package com.example.nikolaiturev.finallyproject.presentation.action_choice_dialog

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import com.example.nikolaiturev.finallyproject.domain.repository.PhotoRepository
import com.example.nikolaiturev.finallyproject.presentation.base.BaseViewModel
import com.example.nikolaiturev.finallyproject.util.Variables
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.io.File

class ActionChoicePhotoViewModel(private val photoRepository: PhotoRepository) : BaseViewModel() {

    fun getPhotoFromGallery(): Intent {
        return Intent(Intent.ACTION_GET_CONTENT).apply {
            type = Variables.TYPE_IMAGE_ALL
        }
    }

    fun takePhoto(): Intent {
        return Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    }

    fun insertPhoto(uri: Uri?) {
        val photo = Photo(name = File(uri.toString()).name, image = uri.toString())
        photoRepository.insertPhoto(photo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = { it.localizedMessage }
            ).addTo(disposable)
    }

    fun navigateToBack() {
        navController.navigateUp()
    }
}
