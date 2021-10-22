package com.android.githubapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [GithubItemDatabase::class],
    version = 1
)
abstract class GithubItemDatabase : RoomDatabase() {

    abstract fun githubDao(): GithubProfileDao
}