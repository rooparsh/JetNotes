package com.darklabs.basecompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darklabs.data.remote.SafeResult
import com.darklabs.domain.usecase.GetRandomJokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getRandomJokeUseCase: GetRandomJokeUseCase) :
    ViewModel() {

    suspend fun getRandomJokes() {

        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getRandomJokeUseCase.perform()) {
                is SafeResult.Failure -> TODO()
                SafeResult.NetworkError -> TODO()
                is SafeResult.Success -> TODO()
            }
        }
    }
}