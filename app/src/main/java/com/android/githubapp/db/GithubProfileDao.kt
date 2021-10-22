package com.android.githubapp.db

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.githubapp.model.GithubProfileItem


@Dao
interface GithubProfileDao {

    @Query("SELECT * FROM githubprofile")
    fun getAllProfiles(): LiveData<List<GithubProfileItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfiles(githubProfile: List<GithubProfileItem>)

    @Query("DELETE FROM githubprofile")
    suspend fun deleteAllProfiles()

    @Delete
    suspend fun deleteProfileItems(githubProfile: GithubProfileItem)


}