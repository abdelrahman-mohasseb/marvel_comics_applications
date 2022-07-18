package com.example.applicationtestjetpackcompose.data.remote.dto

/**
 * Data Transferable Object that represents all the data of the comics.
 */

data class DataDto(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ComicDto>,
    val total: Int
)