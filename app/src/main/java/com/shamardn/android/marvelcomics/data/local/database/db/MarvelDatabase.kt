package com.shamardn.android.marvelcomics.data.local.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shamardn.android.marvelcomics.data.local.database.Converters
import com.shamardn.android.marvelcomics.data.local.database.dao.MarvelDao
import com.shamardn.android.marvelcomics.data.local.database.entity.CharacterEntity
import com.shamardn.android.marvelcomics.data.local.database.entity.ComicEntity
import com.shamardn.android.marvelcomics.data.local.database.entity.SeriesEntity
import com.shamardn.android.marvelcomics.data.local.database.entity.StoryEntity

@TypeConverters(Converters::class)
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