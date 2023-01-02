package com.shamardn.android.marvelcomics.domain.usecase

import com.shamardn.android.marvelcomics.data.repository.MarvelRepository
import com.shamardn.android.marvelcomics.domain.mapper.StoryDetailsMapper
import com.shamardn.android.marvelcomics.domain.model.MarvelStory
import javax.inject.Inject

class FetchMarvelStoryByIdUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository,
    private val storyDetailsMapper: StoryDetailsMapper,
) {
    suspend operator fun invoke(storyId: Int): MarvelStory {
        return storyDetailsMapper.map( marvelRepository.getStoryDetailsById(storyId))
    }
}