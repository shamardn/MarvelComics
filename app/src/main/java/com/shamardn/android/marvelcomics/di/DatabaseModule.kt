package com.shamardn.android.marvelcomics.di

import android.content.Context
import androidx.room.Room
import com.shamardn.android.marvelcomics.data.local.database.dao.MarvelDao
import com.shamardn.android.marvelcomics.data.local.database.db.MarvelDatabase
import com.shamardn.android.marvelcomics.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MarvelDatabase {
        return Room.databaseBuilder(
            context,
            MarvelDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideMarvelDao(database: MarvelDatabase): MarvelDao {
        return database.marvelDao()
    }
}