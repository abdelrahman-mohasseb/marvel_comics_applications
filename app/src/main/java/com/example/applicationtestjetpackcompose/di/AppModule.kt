package com.example.applicationtestjetpackcompose.di

import android.app.Application
import androidx.room.Room
import com.example.applicationtestjetpackcompose.BuildConfig
import com.example.applicationtestjetpackcompose.data.local.ComicDatabase
import com.example.applicationtestjetpackcompose.data.remote.MarvelComicsApi
import com.example.applicationtestjetpackcompose.utilities.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStockApi(): MarvelComicsApi {
        val httpClient =
            if (BuildConfig.DEBUG){
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            }else{
                OkHttpClient
                    .Builder()
                    .build()
            }

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(MarvelComicsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStockDatabase(app: Application): ComicDatabase {
        return Room.databaseBuilder(
            app,
            ComicDatabase::class.java,
            "comicsdb.db"
        ).build()
    }
}
