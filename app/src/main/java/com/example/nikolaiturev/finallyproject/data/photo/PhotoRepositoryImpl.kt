package com.example.nikolaiturev.finallyproject.data.photo

import com.example.nikolaiturev.finallyproject.data.dao.PhotoDao
import com.example.nikolaiturev.finallyproject.domain.entity.Image
import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import com.example.nikolaiturev.finallyproject.domain.repository.PhotoRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class PhotoRepositoryImpl(private val finallyProjectDao: PhotoDao) : PhotoRepository {

    override fun getPhotos(): Observable<List<Photo>> = finallyProjectDao.getPhotos()

    override fun getImages(): Single<List<Image>>  = finallyProjectDao.getImages()

    override fun insertPhoto(photo: Photo): Completable = finallyProjectDao.insertPhoto(photo)

    override fun deletePhoto(photo: Photo): Completable = finallyProjectDao.deletePhoto(photo)
}
