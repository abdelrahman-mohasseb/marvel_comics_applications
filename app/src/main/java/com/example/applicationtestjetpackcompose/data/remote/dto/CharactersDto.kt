package com.example.applicationtestjetpackcompose.data.remote.dto

data class CharactersDto(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXDto>,
    val returned: Int
)