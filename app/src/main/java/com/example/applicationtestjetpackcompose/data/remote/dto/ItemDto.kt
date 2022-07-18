package com.example.applicationtestjetpackcompose.data.remote.dto

import com.example.applicationtestjetpackcompose.domain.model.Creator

data class ItemDto(
    val name: String,
    val resourceURI: String,
    val role: String
)