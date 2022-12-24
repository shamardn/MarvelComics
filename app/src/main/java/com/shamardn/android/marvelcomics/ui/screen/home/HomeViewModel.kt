package com.shamardn.android.marvelcomics.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelCharactersUseCase
import com.shamardn.android.marvelcomics.domain.usecase.FetchMarvelComicsUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.CharactersUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.comics.mapper.ComicsUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.home.uistate.HomeUiState
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
    private val charactersUiStateMapper: CharactersUiStateMapper,
    private val comicsUiStateMapper: ComicsUiStateMapper,
): ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getCharacters()
        getComics()
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