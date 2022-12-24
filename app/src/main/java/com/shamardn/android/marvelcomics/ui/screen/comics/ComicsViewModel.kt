package com.shamardn.android.marvelcomics.ui.screen.comics

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsByCharacterIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.comics.mapper.ComicsUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val fetchMarvelComic: FetchMarvelComicsByCharacterIdUseCase,
    private val comicsUiStateMapper: ComicsUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(ComicsUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    val id = arg.toInt()
    init {
        getComicsByCharacterId()
    }

    private fun getComicsByCharacterId() {
        viewModelScope.launch {
            try {
                val comics = fetchMarvelComic(id).map { comicsUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelComics = comics
                )
                }
            } catch (e: Throwable) {
                _state.update {
                    it.copy(
                        isError = true,
                    )
                }
            }
        }
    }
}