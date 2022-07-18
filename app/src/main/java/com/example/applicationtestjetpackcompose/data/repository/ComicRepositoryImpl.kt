package com.example.applicationtestjetpackcompose.data.repository

import com.example.applicationtestjetpackcompose.data.local.ComicDatabase
import com.example.applicationtestjetpackcompose.data.mapper.toComic
import com.example.applicationtestjetpackcompose.data.mapper.toMarvelApiResponse
import com.example.applicationtestjetpackcompose.data.remote.MarvelComicsApi
import com.example.applicationtestjetpackcompose.domain.model.Comic
import com.example.applicationtestjetpackcompose.domain.model.MarvelApiResponse
import com.example.applicationtestjetpackcompose.domain.repository.ComicRepository
import com.example.applicationtestjetpackcompose.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicRepositoryImpl @Inject constructor(
    private val api : MarvelComicsApi,
    private val db : ComicDatabase
): ComicRepository {

    private val dao = db.comicDao
    override suspend fun getAllComicsCached(): Flow<Resource<List<Comic>>> {
        return flow {
            emit(Resource.Loading(true))
            val localComics = dao.getAllComics()
            emit(Resource.Success(
                data = localComics.map { it.toComic() }
            ))
        }
    }

    override suspend fun getAllSearchedComicsCached(search: String): Flow<Resource<List<Comic>>> {
        return flow {
            emit(Resource.Loading(true))
            val localComics = dao.getSearchedComics(search)
            emit(Resource.Success(
                data = localComics.map { it.toComic() }
            ))
        }
    }

    override suspend fun getAllComicsFromServer(): Flow<Resource<List<Comic>>> {
        return flow {
            val remoteListOfComics = try {
                val response = api.getAllComicsDetails().body()?.toMarvelApiResponse()
                if (response != null) {
                    if (response.code == 200 && response.status == "OK") {
                     emit(   Resource.Success(response.data))
                        emit(Resource.Loading(false))
                    } else {
                        emit(   Resource.Error(response.status))
                        emit(Resource.Loading(false))
                    }
                } else {
                    emit(  Resource.Error(message = "Couldn't load data"))
                    emit(Resource.Loading(false))
                }

            } catch (e: IOException) {
                e.printStackTrace()
                emit(  Resource.Error(
                    message = "Couldn't load data"
                ))
                emit(Resource.Loading(false))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(  Resource.Error(
                    message = "Couldn't load data"
                ))
                emit(Resource.Loading(false))
            }
        }
    }


    override suspend fun getAllSearchedComicsFromServer(search: String) : Flow<Resource<List<Comic>>> {

        return flow {
            val remoteSearchedListOfComics = try {
                val response =
                    api.getAllSearchedComics(search = search).body()?.toMarvelApiResponse()
                if (response != null) {
                    if (response.code == 200 && response.status == "OK") {
                        emit(Resource.Success(response.data))
                        emit(Resource.Loading(false))
                    } else {
                        emit(Resource.Error(response.status))
                        emit(Resource.Loading(false))
                    }
                } else {
                    emit(Resource.Error(message = "Couldn't load data"))
                    emit(Resource.Loading(false))
                }

            } catch (e: IOException) {
                e.printStackTrace()
                emit(
                    Resource.Error(
                        message = "Couldn't load data"
                    )
                )
                emit(Resource.Loading(false))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(
                    Resource.Error(
                        message = "Couldn't load data"
                    ) )
                emit(Resource.Loading(false))
            }
        }
    }
}
