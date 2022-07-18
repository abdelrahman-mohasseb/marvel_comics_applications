package com.example.applicationtestjetpackcompose.presentation.comics_list

sealed class ComicsListEvent {
    object Refresh: ComicsListEvent()
    data class OnSearchQueryChange(val query: String) : ComicsListEvent()
}