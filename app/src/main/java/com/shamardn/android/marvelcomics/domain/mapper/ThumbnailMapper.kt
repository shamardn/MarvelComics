package com.shamardn.android.marvelcomics.domain.mapper

import com.shamardn.android.marvelcomics.data.remote.response.common.ThumbnailDTO
import com.shamardn.android.marvelcomics.domain.model.Thumbnail
import javax.inject.Inject

class ThumbnailMapper @Inject constructor(
): Mapper<ThumbnailDTO, Thumbnail>() {
    override fun map(input: ThumbnailDTO): Thumbnail {
        return Thumbnail(
            path = input.path ?: "",
            extension = input.extension ?: "",
        )
    }
}