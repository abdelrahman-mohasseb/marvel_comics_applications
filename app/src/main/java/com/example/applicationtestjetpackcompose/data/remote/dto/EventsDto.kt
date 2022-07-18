package com.example.applicationtestjetpackcompose.data.remote.dto

data class EventsDto(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)