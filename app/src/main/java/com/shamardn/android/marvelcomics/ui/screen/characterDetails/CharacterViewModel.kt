package com.shamardn.android.marvelcomics.ui.screen.characterDetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shamardn.android.marvelcomics.domain.usecase.FetchCharacterIdUseCase
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.toCharactersDetailsUiState
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.uistate.CharacterDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    val getCharacterDetails: FetchCharacterIdUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailsUiState())
    val state = _state.asStateFlow()
    private val arg: String = checkNotNull(savedStateHandle["id"])

    init {
        getCharacterById()
    }

    private fun getCharacterById(){
        _state.update { it.copy( id = arg.toInt() ) }
        val id = _state.value.id
        viewModelScope.launch {
            try {
                Log.i("wsh"," id = ${_state.value.id}")
               val currentCharacter = getCharacterDetails(id).toCharactersDetailsUiState()
                _state.update { it.copy(
                    id = currentCharacter.id,
                    name = currentCharacter.name,
                    description = currentCharacter.description,
                    modifiedDate = currentCharacter.modifiedDate,
                    thumbnail = currentCharacter.thumbnail,
                    resourceURI = currentCharacter.resourceURI,
                )
                }
                Log.i("wsh"," currentCharacter = $currentCharacter")

            }catch (e: Exception){
                throw e
            }
        }
    }

}