package com.example.nikolaiturev.finallyproject.data.dao

import androidx.room.*
import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo ORDER BY id")
    fun getPhotos(): Observable<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPhoto(photo: Photo): Completable

    @Update
    fun updatePhoto(photo: Photo): Completable

    @Delete
    fun deletePhoto(photo: Photo): Completable
}
