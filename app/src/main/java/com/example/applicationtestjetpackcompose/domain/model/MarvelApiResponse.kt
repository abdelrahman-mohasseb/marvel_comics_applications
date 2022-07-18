package com.example.applicationtestjetpackcompose.domain.model

import com.example.applicationtestjetpackcompose.data.remote.dto.DataDto

data class MarvelApiResponse (
    val code: Int,
    val data: List<Comic>,
    val status: String,
)