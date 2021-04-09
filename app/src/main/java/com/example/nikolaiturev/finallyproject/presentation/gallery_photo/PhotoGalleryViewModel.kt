package com.example.nikolaiturev.finallyproject.presentation.gallery_photo

import androidx.lifecycle.MutableLiveData
import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import com.example.nikolaiturev.finallyproject.domain.repository.PhotoRepository
import com.example.nikolaiturev.finallyproject.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class PhotoGalleryViewModel(private val photoRepository: PhotoRepository) : BaseViewModel() {

    val photoLiveData = MutableLiveData<List<Photo>>()

    init {
        getPhotos()
    }

    fun navigateToActionChoiceDialog() {
        navController.navigate(R.id.action_photoGalleryFragment2_to_actionChoicePhotoDialog)
    }

    private fun getPhotos() {
        photoRepository.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isInProgress.value = false }
            .doFinally { isInProgress.value = true }
            .subscribeBy(
                onNext = { photoLiveData.value = it },
                onError = { it.localizedMessage }
            ).addTo(disposable)
    }

    fun deletePhoto(photo: Photo) {
        photoRepository.deletePhoto(photo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = { it.localizedMessage }
            ).addTo(disposable)
    }
}
