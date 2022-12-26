package com.shamardn.android.marvelcomics.ui.screen.characters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersByComicIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersBySeriesIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.CharactersUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val fetchMarvelCharacterByComicId: FetchMarvelCharactersByComicIdUseCase,
    private val fetchMarvelCharacterByCSeriesId: FetchMarvelCharactersBySeriesIdUseCase,
    private val charactersUiStateMapper: CharactersUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(CharactersUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    val id = arg.toInt()
    init {
        getCharactersByComicsId()
    }

    private fun getCharactersByComicsId() {
        viewModelScope.launch {
            try {
                val characters = fetchMarvelCharacterByComicId(id).map { charactersUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelCharacters = characters
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
    private fun getCharactersBySeriesId() {
        viewModelScope.launch {
            try {
                val characters = fetchMarvelCharacterByCSeriesId(id).map { charactersUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelCharacters = characters
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