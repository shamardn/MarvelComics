package com.shamardn.android.marvelcomics.ui.screen.storyDetails.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelStory
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.MarvelListBasicToUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.stories.uistate.StoryDetailsUiState
import javax.inject.Inject

class StoryUiStateMapper @Inject constructor(
    private val marvelListBasicToUiStateMapper: MarvelListBasicToUiStateMapper,
): Mapper<MarvelStory, StoryDetailsUiState>(){
    override fun map(input: MarvelStory): StoryDetailsUiState {
        return StoryDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
            modified = input.modifiedDate,
            comics = marvelListBasicToUiStateMapper.map(input.comics),
            series = marvelListBasicToUiStateMapper.map(input.series),
            characters = marvelListBasicToUiStateMapper.map(input.characters),
        )
    }
}