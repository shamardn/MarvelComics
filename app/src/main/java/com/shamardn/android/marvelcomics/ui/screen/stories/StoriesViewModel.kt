package com.shamardn.android.marvelcomics.ui.screen.stories

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelStoriesByCharacterIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelStoriesByComicIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelStoriesBySeriesIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.stories.mapper.StoriesUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.stories.uistate.StoriesUiState
import com.shamardn.android.marvelcomics.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val fetchMarvelStoriesByCharacterId: FetchMarvelStoriesByCharacterIdUseCase,
    private val fetchMarvelStoriesBySeriesId: FetchMarvelStoriesBySeriesIdUseCase,
    private val fetchMarvelStoriesByComicId: FetchMarvelStoriesByComicIdUseCase,
    private val storiesUiStateMapper: StoriesUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(StoriesUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    private val argIdType: String = checkNotNull(savedStateHandle["idType"])
    private val id = arg.toInt()
    private val idType = argIdType.toInt()
    init {
        _state.update {
            it.copy(
                isLoading = true,
                isError = false,
            )
        }
        checkIdType(idType)
    }

    private fun checkIdType(idType: Int) {
        when (idType) {
            Constants.CHARACTER_TYPE -> {
                getStoriesByCharacterId()
            }
            Constants.SERIES_TYPE -> {
                getStoriesBySeriesId()
            }
            Constants.COMIC_TYPE -> {
                getStoriesByComicId()
            }
            else -> {
            }
        }
    }

    private fun getStoriesByCharacterId() {
        viewModelScope.launch {
            try {
                val stories = fetchMarvelStoriesByCharacterId(id).map { storiesUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelStories = stories,
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

    private fun getStoriesByComicId() {
        viewModelScope.launch {
            try {
                val stories = fetchMarvelStoriesByComicId(id).map { storiesUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelStories = stories,
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

    private fun getStoriesBySeriesId() {
        viewModelScope.launch {
            try {
                val stories = fetchMarvelStoriesBySeriesId(id).map { storiesUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelStories = stories,
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
    fun onClickTryAgain(){
        _state.update {
            it.copy(
                isLoading = true,
                isError = false,
            )
        }
        checkIdType(idType)
    }
}