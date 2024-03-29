package com.shamardn.android.marvelcomics.ui.screen.characterDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharacterIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.CharactersUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    val getCharacterDetails: FetchMarvelCharacterIdUseCase,
    val charactersUiStateMapper: CharactersUiStateMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailsUiState())
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
        getCharacterById()
    }

    private fun getCharacterById() {
        viewModelScope.launch {
            try {
                val currentCharacter = charactersUiStateMapper.map(getCharacterDetails(id))
                _state.update {
                    it.copy(
                        id = currentCharacter.id,
                        title = currentCharacter.title,
                        description = currentCharacter.description,
                        modifiedDate = currentCharacter.modifiedDate,
                        thumbnail = currentCharacter.thumbnail,
                        resourceURI = currentCharacter.resourceURI,
                        comics = currentCharacter.comics,
                        series = currentCharacter.series,
                        stories = currentCharacter.stories,
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
        getCharacterById()
    }
}