package com.shamardn.android.marvelcomics.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelSeriesUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.CharactersUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.mapper.ComicsUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.HomeUiState
import com.shamardn.android.marvelcomics.ui.screen.series.mapper.SeriesUiStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchMarvelCharactersUseCase: FetchMarvelCharactersUseCase,
    private val getComicsUseCase: FetchMarvelComicsUseCase,
    private val getSeriesUseCase: FetchMarvelSeriesUseCase,
    private val charactersUiStateMapper: CharactersUiStateMapper,
    private val comicsUiStateMapper: ComicsUiStateMapper,
    private val seriesUiStateMapper: SeriesUiStateMapper,
): ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getCharacters()
        getComics()
        getSeries()
    }

    private fun getSeries() {
        viewModelScope.launch {
            try {
                val series = getSeriesUseCase().map { seriesUiStateMapper.map(it) }
                Log.i("wshamardn", "series = $series ")
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

    private fun getCharacters(){
        viewModelScope.launch {
            try {
                val characters = fetchMarvelCharactersUseCase().map { charactersUiStateMapper.map(it) }
                Log.i("wshamardn", "characters = $characters ")
                _state.update { it.copy(
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
    private fun getComics(){
        viewModelScope.launch {
            try {
                val comics = getComicsUseCase().map { comicsUiStateMapper.map(it) }
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