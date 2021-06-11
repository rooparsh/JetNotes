package com.darklabs.data.remote

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

internal suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> Response<T>
): SafeResult<T> {
    return withContext(dispatcher) {
        try {
            apiCall.invoke().resolveResponse()
        } catch (throwable: Throwable) {
            Log.e("safeApiCall", throwable.message.toString())
            when (throwable) {
                is IOException -> SafeResult.NetworkError
                is HttpException -> SafeResult.Failure(throwable)
                else -> SafeResult.Failure(Exception(throwable))
            }
        }
    }
}

private fun <T> Response<T>.resolveResponse(): SafeResult<T> {
    return if (isSuccessful) {
        body()?.let { SafeResult.Success(it) }
            ?: kotlin.run { SafeResult.Failure(message = "No data") }
    } else {
        SafeResult.Failure(message = this.errorBody()?.charStream()?.readText().orEmpty())
    }
}
