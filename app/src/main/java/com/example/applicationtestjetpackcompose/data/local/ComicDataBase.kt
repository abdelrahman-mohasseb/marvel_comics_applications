package com.example.applicationtestjetpackcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.applicationtestjetpackcompose.data.local.entity.ComicEntity

@Database(entities = [ComicEntity::class], version = 1, exportSchema = false)

@TypeConverters(Converters::class)
abstract class ComicDatabase : RoomDatabase() {
    abstract val comicDao: ComicDao
}