package com.shamardn.android.marvelcomics.ui.screen.stories.mapper

import com.shamardn.android.marvelcomics.domain.mapper.Mapper
import com.shamardn.android.marvelcomics.domain.model.MarvelStory
import com.shamardn.android.marvelcomics.ui.screen.characterDetails.mapper.MarvelListBasicToUiStateMapper
import com.shamardn.android.marvelcomics.ui.screen.stories.uistate.StoryDetailsUiState
import javax.inject.Inject

class StoriesUiStateMapper @Inject constructor(
    private val marvelListBasicToUiStateMapper: MarvelListBasicToUiStateMapper,
): Mapper<MarvelStory, StoryDetailsUiState>(){
    override fun map(input: MarvelStory): StoryDetailsUiState {
        return StoryDetailsUiState(
            id = input.id,
            title = input.title,
            description = input.description,
            modified = input.modifiedDate,
            characters = marvelListBasicToUiStateMapper.map(input.characters),
            series = marvelListBasicToUiStateMapper.map(input.series),
            comics = marvelListBasicToUiStateMapper.map(input.comics),
        )
    }
}