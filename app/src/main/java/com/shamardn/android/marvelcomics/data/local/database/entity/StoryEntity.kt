package com.shamardn.android.marvelcomics.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shamardn.android.marvelcomics.utils.Constants
import java.util.*

@Entity(tableName = Constants.STORY_TABLE)
data class StoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val modified: Date,
//    val thumbnail: Thumbnail,
)
