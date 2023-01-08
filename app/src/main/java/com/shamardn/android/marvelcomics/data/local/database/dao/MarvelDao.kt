package com.shamardn.android.marvelcomics.data.local.database.dao

import androidx.room.*
import com.shamardn.android.marvelcomics.data.local.database.entity.CharacterEntity

@Dao
interface MarvelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characterList: List<CharacterEntity>)

    @Update
    suspend fun updateCharacters(characterList: List<CharacterEntity>)

    @Query("SELECT * FROM CHARACTER_TABLE")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Query("DELETE FROM CHARACTER_TABLE")
    suspend fun deleteAllCharacters()
}