package com.example.applicationtestjetpackcompose.data.remote.dto

data class StoriesDto(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXDto>,
    val returned: Int
)