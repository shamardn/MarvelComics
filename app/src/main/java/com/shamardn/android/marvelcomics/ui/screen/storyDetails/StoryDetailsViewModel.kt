package com.shamardn.android.marvelcomics.ui.screen.characterDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelStoryByIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.stories.uistate.StoryDetailsUiState
import com.shamardn.android.marvelcomics.ui.screen.storyDetails.mapper.StoryUiStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryDetailsViewModel @Inject constructor(
    val fetchMarvelStoryByIdUseCase: FetchMarvelStoryByIdUseCase,
    private val storyUiStateMapper: StoryUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(StoryDetailsUiState())
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
        getStoryById()
    }

    private fun getStoryById() {
        viewModelScope.launch {
            try {
                val currentStory = storyUiStateMapper.map(fetchMarvelStoryByIdUseCase(id))
                _state.update {
                    it.copy(
                        id = currentStory.id,
                        title = currentStory.title,
                        description = currentStory.description,
                        modified = currentStory.modified,
                        comics = currentStory.comics,
                        series = currentStory.series,
                        characters = currentStory.characters,
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
        getStoryById()
    }
}