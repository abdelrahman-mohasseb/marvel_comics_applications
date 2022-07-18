package com.example.applicationtestjetpackcompose.domain.model



data class Comic(
    val characters: List<String>,
    val creators: List<Creator>,
    val dates: List<Date>,
    val description: String?,
    val images: List<String>,
    val issueNumber: Int,
    val pageCount: Int,
    val prices: List<Int>,
    val series: String,
    val thumbnail: String,
    val title: String,
    val isFavorite : Boolean,
)
