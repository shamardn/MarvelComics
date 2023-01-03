package com.shamardn.android.marvelcomics.ui.screen.series

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelSeriesByCharacterIdUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelSeriesByStoryIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.series.mapper.SeriesUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.series.uistate.SeriesUiState
import com.shamardn.android.marvelcomics.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val fetchMarvelSeriesByCharacterId: FetchMarvelSeriesByCharacterIdUseCase,
    private val fetchMarvelSeriesByStoryId: FetchMarvelSeriesByStoryIdUseCase,
    private val SeriesUiStateMapper: SeriesUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(SeriesUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    private val argIdType: String = checkNotNull(savedStateHandle["idType"])
    private val id = arg.toInt()
    private val idType = argIdType.toInt()
    init {
        checkIdType(idType)
    }

    private fun checkIdType(idType: Int) {
        when (idType) {
            Constants.CHARACTER_TYPE -> {
                getSeriesByCharacterId()
            }
            Constants.STORY_TYPE -> {
                getSeriesByStoryId()
            }
            else -> {

            }
        }
    }

    private fun getSeriesByCharacterId() {
        viewModelScope.launch {
            try {
                val Series = fetchMarvelSeriesByCharacterId(id).map { SeriesUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelSeries = Series
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

    private fun getSeriesByStoryId() {
        viewModelScope.launch {
            try {
                val series = fetchMarvelSeriesByStoryId(id).map { SeriesUiStateMapper.map(it) }
                _state.update { it.copy(
                    marvelSeries = series
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