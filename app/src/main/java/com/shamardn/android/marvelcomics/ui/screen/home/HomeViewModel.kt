package com.shamardn.android.marvelcomics.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.GetMarvelCharactersUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.toCharactersDetailsUiState
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.CharactersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMarvelCharactersUseCase: GetMarvelCharactersUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CharactersUiState())
    val state = _state.asStateFlow()

    init {
        getCharacters()
    }
    fun getCharacters(){
        viewModelScope.launch {
            try {
                val characters = getMarvelCharactersUseCase().map { it.toCharactersDetailsUiState() }
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
}