package com.shamardn.android.marvelcomics.ui.screen.characters

import androidx.lifecycle.ViewModel
import com.shamardn.android.marvelcomics.ui.screen.characters.uistate.CharactersDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(CharactersDetailsUiState())
    val state = _state.asStateFlow()

    fun updateCurrentCharacter(currentCharacter: CharactersDetailsUiState){
        _state.value = currentCharacter
    }

}