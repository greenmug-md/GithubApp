package com.android.githubapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.githubapp.model.GithubProfileItem
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubProfileDao {

    @Query("SELECT * FROM githubprofile")
    fun getAllProfiles(): Flow<List<GithubProfileItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfiles(restaurants: List<GithubProfileItem>)

    @Query("DELETE FROM githubprofile")
    suspend fun deleteAllProfiles()

}