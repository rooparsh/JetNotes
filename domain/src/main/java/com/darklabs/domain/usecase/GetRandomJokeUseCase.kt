package com.darklabs.domain.usecase

import com.darklabs.data.remote.SafeResult
import com.darklabs.data.repository.JokeRepository
import com.darklabs.domain.mapper.toJokes
import com.darklabs.domain.model.Joke
import javax.inject.Inject

class GetRandomJokeUseCase @Inject constructor(
    private val jokeRepository: JokeRepository
) : BaseUseCase<Unit, SafeResult<List<Joke>>> {

    override suspend fun perform(): SafeResult<List<Joke>> {
        return when (val result = jokeRepository.getRandomJokes()) {
            is SafeResult.Success -> {
                SafeResult.Success(result.data.toJokes())
            }
            is SafeResult.Failure -> result
            is SafeResult.NetworkError -> result
        }
    }

}