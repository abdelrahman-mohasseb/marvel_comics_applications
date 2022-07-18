package com.example.applicationtestjetpackcompose.data.local

import androidx.room.*
import com.example.applicationtestjetpackcompose.data.local.entity.ComicEntity


@Dao
interface ComicDao{
    /// if we insert a comic with existing id in the database, it will be replaced automatically
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComic(comic: ComicEntity)

    @Delete
    suspend fun deleteComic(comic: ComicEntity)

    @Query("SELECT * FROM comics_table")
    suspend fun getAllComics(): List<ComicEntity>

    @Query("""SELECT * FROM comics_table WHERE LOWER(title) LIKE '%' || LOWER(:title) || '%'""")
    suspend fun getSearchedComics(title:String): List<ComicEntity>



}