package com.shamardn.android.marvelcomics.ui.screen.comicDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.comicDetails.mapper.ComicsUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.uistate.ComicDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicDetailsViewModel @Inject constructor(
    val getComicDetails: FetchMarvelComicIdUseCase,
    val comicsUiStateMapper: ComicsUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(ComicDetailsUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])
    val id = arg.toInt()

    init {
        _state.update {
            it.copy(
                isLoading = true,
                isError = false,
            )
        }
        getComicById()
    }

    private fun getComicById() {
        viewModelScope.launch {
            try {
                val currentComic = comicsUiStateMapper.map(getComicDetails(id))
                _state.update {
                    it.copy(
                        id = currentComic.id,
                        title = currentComic.title,
                        description = currentComic.description,
                        modified = currentComic.modified,
                        thumbnail = currentComic.thumbnail,
                        characters = currentComic.characters,
                        series = currentComic.series,
                        stories = currentComic.stories,
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
        getComicById()
    }
}