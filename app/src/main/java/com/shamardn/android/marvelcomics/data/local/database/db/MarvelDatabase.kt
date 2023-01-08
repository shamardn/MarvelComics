package com.shamardn.android.marvelcomics.data.local.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shamardn.android.marvelcomics.data.local.database.dao.MarvelDao
import com.shamardn.android.marvelcomics.data.local.database.entity.CharacterEntity
import com.shamardn.android.marvelcomics.data.local.database.entity.ComicEntity
import com.shamardn.android.marvelcomics.data.local.database.entity.SeriesEntity
import com.shamardn.android.marvelcomics.data.local.database.entity.StoryEntity

@Database(
    entities = [
        CharacterEntity::class,
        ComicEntity::class,
        SeriesEntity::class,
        StoryEntity::class,
    ], version = 1
)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}