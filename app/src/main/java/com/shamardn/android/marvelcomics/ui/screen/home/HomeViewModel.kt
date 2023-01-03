package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelSeriesUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelStoriesUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.CharactersUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.mapper.ComicsUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.HomeUiState
import com.shamardn.android.marvelcomics.ui.screen.series.mapper.SeriesUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.stories.mapper.StoriesUiStateMapper
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
    private val getStoriesUseCase: FetchMarvelStoriesUseCase,
    private val charactersUiStateMapper: CharactersUiStateMapper,
    private val comicsUiStateMapper: ComicsUiStateMapper,
    private val seriesUiStateMapper: SeriesUiStateMapper,
    private val storiesUiStateMapper: StoriesUiStateMapper,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                isLoading = true,
                isError = false,
            )
        }
        getCharacters()
        getComics()
        getSeries()
        getStories()
    }

    private fun getStories() {
        viewModelScope.launch {
            try {
                val stories = getStoriesUseCase().map { storiesUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelStories = stories,
                        isError = false,
                        isLoading = false,
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

    private fun getSeries() {
        viewModelScope.launch {
            try {
                val series = getSeriesUseCase().map { seriesUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelSeries = series,
                        isError = false,
                        isLoading = false,
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

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                val characters =
                    fetchMarvelCharactersUseCase().map { charactersUiStateMapper.map(it) }
                _state.update {
                    it.copy(
                        marvelCharacters = characters,
                        isError = false,
                        isLoading = false,
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

    private fun getComics() {
        viewModelScope.launch {
            try {
                val comics = getComicsUseCase().map { comicsUiStateMapper.map(it) }
                _state.update {
                    it.copy(
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

    fun onClickTryAgain(){
        _state.update {
            it.copy(
                isLoading = true,
                isError = false,
            ) }
        getCharacters()
        getComics()
        getSeries()
        getStories()
    }
}