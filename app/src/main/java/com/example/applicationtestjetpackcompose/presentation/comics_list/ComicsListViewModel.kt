package com.example.applicationtestjetpackcompose.presentation.comics_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationtestjetpackcompose.domain.repository.ComicRepository
import com.example.applicationtestjetpackcompose.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsListViewModel @Inject constructor(
    private val repository: ComicRepository
): ViewModel() {
    var state by mutableStateOf(ComicListState())
    private var searchJob: Job? = null


    fun onEvent(event: ComicsListEvent) {
        when(event) {
            is ComicsListEvent.Refresh -> {
                getAllComicsFromServer()
            }
            is ComicsListEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getSearchedComicsFromServer()
                }
            }
        }
    }

    private fun getAllComicsFromServer() {
        viewModelScope.launch {
            repository.getAllComicsFromServer()
                .collect {
                        result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { comics ->
                                state = state.copy(
                                    comics = comics
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }

    private fun  getSearchedComicsFromServer(query: String = state.searchQuery.lowercase(),) {
        viewModelScope.launch {
            repository.getAllSearchedComicsFromServer(query)
                .collect {
                        result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { comics ->
                                state = state.copy(
                                    comics = comics
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}