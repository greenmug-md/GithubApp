package com.android.githubapp.response


sealed class Response<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : Response<T>(Status.SUCCESS,data)

    class Error<T>(message: String?, data: T? = null) : Response<T>(Status.ERROR,data, message)

    class Loading<T>(message: String?, data: T? = null) : Response<T>(Status.LOADING,data, null)

    class Empty<T>(message: String?, data: T? = null) : Response<T>(Status.EMPTY)
}
