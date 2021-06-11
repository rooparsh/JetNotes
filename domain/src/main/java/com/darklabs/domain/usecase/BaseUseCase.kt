package com.darklabs.domain.usecase

interface BaseUseCase<in Params, out Result> {
    suspend fun perform(): Result = throw NotImplementedError()
    suspend fun perform(params: Params): Result = throw NotImplementedError()
}