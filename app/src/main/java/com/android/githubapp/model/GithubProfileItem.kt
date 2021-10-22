package com.android.githubapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubprofile")
data class GithubProfileItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    @PrimaryKey
    val name: String,
    @SerializedName("url")
    val url: String
)