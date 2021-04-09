package com.example.nikolaiturev.finallyproject.domain.repository

import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import io.reactivex.Completable
import io.reactivex.Observable

interface PhotoRepository {

    fun getPhotos(): Observable<List<Photo>>

    fun insertPhoto(photo: Photo): Completable

    fun deletePhoto(photo: Photo): Completable
}
