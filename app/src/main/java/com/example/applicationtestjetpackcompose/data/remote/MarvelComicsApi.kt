package com.example.applicationtestjetpackcompose.data.remote

import com.example.applicationtestjetpackcompose.BuildConfig
import com.example.applicationtestjetpackcompose.data.remote.dto.MarvelApiResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Define the network requests used throughout the app.
 */

interface MarvelComicsApi {

    /// Function to get the details of the comics on the Marvel Api
    @GET("v1/public/comics")
    suspend fun getAllComicsDetails(
      ///  [formatType] specify the type from comics or collections
        @Query("formatType")
        formatType: String = "comic",
      /// [noVariants] specify if we want the results with alternative versions or not
        @Query("noVariants")
        noVariants: Boolean = true,
      /// [apiKey] used to authorize the access to the api, and generated when build of the app is done as a security process
        @Query("apiKey")
        apiKey: String = BuildConfig.MARVEL_ACCESS_KEY

    ): Response<MarvelApiResponseDto>


    @GET("/v1/public/comics")
    suspend fun getAllSearchedComics(
        ///  [formatType] specify the type from comics or collections
        @Query("formatType")
        formatType: String = "comic",
        /// [noVariants] specify if we want the results with alternative versions or not
        @Query("noVariants")
        noVariants: Boolean = true,
        /// [apiKey] used to authorize the access to the api, and generated when build of the app is done as a security process
        @Query("apiKey")
        apiKey: String = BuildConfig.MARVEL_ACCESS_KEY,
        /// [titleStartsWith] used to get comics whose title starts with the input. the access to the api, and generated when build of the app is done as a security process
        @Query("titleStartsWith")
        search:String
    ): Response<MarvelApiResponseDto>


}