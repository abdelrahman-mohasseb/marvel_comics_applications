package com.example.applicationtestjetpackcompose.presentation.comics_list

import com.example.applicationtestjetpackcompose.domain.model.Comic

data class ComicListState(

    val comics : List<Comic> = emptyList(),
    val isLoading : Boolean = false,
    val searchQuery : String = "",
    val isRefreshing: Boolean = false,
)
