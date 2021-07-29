package com.darklabs.basecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darklabs.basecompose.util.CoroutineDispatcherProvider
import com.darklabs.domain.model.Note
import com.darklabs.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val notesUseCase: GetNotesUseCase,
    private val dispatcher: CoroutineDispatcherProvider
) :
    ViewModel() {

    var notesList by mutableStateOf(emptyList<Note>())
        private set

    fun getNotes() {
        viewModelScope.launch(dispatcher.io()) {
            notesList = notesUseCase.perform()
        }
    }
}