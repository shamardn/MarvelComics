package com.shamardn.android.marvelcomics.ui.screen.seriesDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelSeriesIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.series.mapper.SeriesUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.series.uistate.SeriesDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesDetailsViewModel @Inject constructor(
    private val getSeriesDetails: FetchMarvelSeriesIdUseCase,
    private val seriesUiStateMapper: SeriesUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(SeriesDetailsUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    val id = arg.toInt()

    init {
        getSeriesById()
    }

    private fun getSeriesById() {
        viewModelScope.launch {
            try {
                val currentSeries = seriesUiStateMapper.map(getSeriesDetails(id))
                _state.update {
                    it.copy(
                        id = currentSeries.id,
                        title = currentSeries.title,
                        description = currentSeries.description,
                        modified = currentSeries.modified,
                        thumbnail = currentSeries.thumbnail,
                        characters = currentSeries.characters,
                        comics = currentSeries.comics,
                        stories = currentSeries.stories,
                    )
                }
            } catch (e: Exception) {
                throw e
            }
        }
    }

}