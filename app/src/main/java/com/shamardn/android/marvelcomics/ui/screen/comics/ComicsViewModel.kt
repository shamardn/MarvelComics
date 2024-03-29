package com.shamardn.android.marvelcomics.ui.screen.comics

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsByCharacterIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsBySeriesIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsByStoryIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.comics.mapper.ComicsUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicsUiState
import com.shamardn.android.marvelcomics.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val fetchMarvelComicByCharacterId: FetchMarvelComicsByCharacterIdUseCase,
    private val fetchMarvelComicBySeriesId: FetchMarvelComicsBySeriesIdUseCase,
    private val fetchMarvelComicByStoryId: FetchMarvelComicsByStoryIdUseCase,
    private val comicsUiStateMapper: ComicsUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(ComicsUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    private val argIdType: String = checkNotNull(savedStateHandle["idType"])
    private val id = arg.toInt()
    private val idType = argIdType.toInt()
    init {
        _state.update { it.copy(
            isLoading = true,
            isError = false,
        ) }
        checkIdType(idType)
    }

    private fun checkIdType(idType: Int) {
        when (idType) {
            Constants.CHARACTER_TYPE -> {
                getComicsByCharacterId()
            }
            Constants.SERIES_TYPE -> {
                getComicsBySeriesId()
            }
            Constants.STORY_TYPE -> {
                getComicsByStoryId()
            }
            else -> {

            }
        }
    }

    private fun getComicsByCharacterId() {
        viewModelScope.launch {
            try {
                val comics = fetchMarvelComicByCharacterId(id).map { comicsUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelComics = comics,
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

    private fun getComicsBySeriesId() {
        viewModelScope.launch {
            try {
                val comics = fetchMarvelComicBySeriesId(id).map { comicsUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelComics = comics,
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

    private fun getComicsByStoryId() {
        viewModelScope.launch {
            try {
                val comics = fetchMarvelComicByStoryId(id).map { comicsUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelComics = comics,
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
    fun onClickTryAgain() {
        _state.update { it.copy(
            isLoading = true,
            isError = false,
        ) }
        checkIdType(idType)
    }
}