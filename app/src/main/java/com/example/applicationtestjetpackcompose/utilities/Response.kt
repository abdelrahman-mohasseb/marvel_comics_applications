package com.example.applicationtestjetpackcompose.utilities


/**
 * this class is used to wrap the api response
 * to differentiate between success response and error response or loading.
 */
sealed class Resource<T>(
    val data: T? = null,  //body of our response
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(val isLoading : Boolean = true) : Resource<T>(null)
}