package com.example.applicationtestjetpackcompose.data.remote.dto

import androidx.lifecycle.Transformations.map
import com.example.applicationtestjetpackcompose.domain.model.Creator

data class CreatorsDto(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemDto>,
    val returned: Int
)
