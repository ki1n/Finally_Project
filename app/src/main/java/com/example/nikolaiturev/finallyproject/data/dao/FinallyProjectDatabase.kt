package com.example.nikolaiturev.finallyproject.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import com.example.nikolaiturev.finallyproject.util.DatabaseConst

@Database(entities = [Photo::class], version = DatabaseConst.DATABASE_VERSION_1)
abstract class FinallyProjectDatabase : RoomDatabase() {

    abstract fun finallyProjectDao() : PhotoDao
}
