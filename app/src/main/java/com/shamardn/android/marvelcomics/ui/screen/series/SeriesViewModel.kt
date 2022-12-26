package com.shamardn.android.marvelcomics.ui.screen.series

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelSeriesByCharacterIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.series.mapper.SeriesUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.series.uistate.SeriesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val fetchMarvelSeries: FetchMarvelSeriesByCharacterIdUseCase,
    private val SeriesUiStateMapper: SeriesUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(SeriesUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    val id = arg.toInt()
    init {
        getSeriesByCharacterId()
    }

    private fun getSeriesByCharacterId() {
        viewModelScope.launch {
            try {
                val Series = fetchMarvelSeries(id).map { SeriesUiStateMapper.map(it) }
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
}