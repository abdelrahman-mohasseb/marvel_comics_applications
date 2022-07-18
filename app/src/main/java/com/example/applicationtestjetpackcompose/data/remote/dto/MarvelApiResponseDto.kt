package com.example.applicationtestjetpackcompose.data.remote.dto

import com.example.applicationtestjetpackcompose.domain.model.MarvelApiResponse

/**
 * Data Transferable Object that represents all the data fetched from the api.
 */

data class MarvelApiResponseDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: DataDto,
    val eTag: String,
    val status: String
)
