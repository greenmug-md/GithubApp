package com.android.githubapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.githubapp.model.GithubProfileItem

@Database(
    entities = [GithubProfileItem::class],
    version = 1
)
abstract class GithubItemDatabase : RoomDatabase() {

    abstract fun githubDao(): GithubProfileDao
}