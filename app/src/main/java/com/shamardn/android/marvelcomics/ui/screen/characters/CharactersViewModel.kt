package com.shamardn.android.marvelcomics.ui.screen.characters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersByComicIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersBySeriesIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersByStoryIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.CharactersUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersUiState
import com.shamardn.android.marvelcomics.utils.Constants
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
    private val fetchMarvelCharacterByStoryId: FetchMarvelCharactersByStoryIdUseCase,
    private val charactersUiStateMapper: CharactersUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(CharactersUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    private val argIdType: String = checkNotNull(savedStateHandle["idType"])
    private val id = arg.toInt()
    private val idType = argIdType.toInt()
    init {
        _state.update {
            it.copy(
                isLoading = true ,
                isError = false,
            ) }
        checkIdType(idType)
    }

    private fun checkIdType(idType: Int) {
        when (idType) {
            Constants.COMIC_TYPE -> {
                getCharactersByComicsId()
            }
            Constants.SERIES_TYPE -> {
                getCharactersBySeriesId()
            }
            Constants.STORY_TYPE -> {
                getCharactersByStoryId()
            }
            else -> {

            }
        }
    }

    private fun getCharactersByComicsId() {
        viewModelScope.launch {
            try {
                val characters = fetchMarvelCharacterByComicId(id).map { charactersUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelCharacters = characters,
                        isLoading = false,
                        isError = false,
                    )
                }
            } catch (e: Throwable) {
                _state.update {
                    it.copy(
                        isError = true,
                        isLoading = false
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
                        marvelCharacters = characters,
                        isLoading = false,
                        isError = false,
                    )
                }
            } catch (e: Throwable) {
                _state.update {
                    it.copy(
                        isError = true,
                        isLoading = false,
                    )
                }
            }
        }
    }

    private fun getCharactersByStoryId() {
        viewModelScope.launch {
            try {
                val characters = fetchMarvelCharacterByStoryId(id).map { charactersUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelCharacters = characters,
                        isLoading = false,
                        isError = false
                    )
                }
            } catch (e: Throwable) {
                _state.update {
                    it.copy(
                        isError = true,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun onClickTryAgain() {
        _state.update {
            it.copy(
                isLoading = true ,
                isError = false,
            ) }
        checkIdType(idType)

    }
}