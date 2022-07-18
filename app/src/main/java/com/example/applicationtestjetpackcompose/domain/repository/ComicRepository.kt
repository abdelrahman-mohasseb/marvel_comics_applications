package com.example.applicationtestjetpackcompose.domain.repository
import com.example.applicationtestjetpackcompose.domain.model.Comic
import com.example.applicationtestjetpackcompose.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface ComicRepository {

    suspend fun getAllComicsFromServer(): Flow<Resource<List<Comic>>>
    suspend fun getAllSearchedComicsFromServer(search:String) :Flow<Resource<List<Comic>>>
    suspend fun getAllComicsCached(): Flow<Resource<List<Comic>>>
    suspend fun getAllSearchedComicsCached(search:String):Flow<Resource<List<Comic>>>

}