package com.android.githubapp.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubprofile")
data class GithubProfileItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("builtBy")
    val builtBy: List<BuiltBy>,
    @SerializedName("currentPeriodStars")
    val currentPeriodStars: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("language")
    val language: String,
    @SerializedName("languageColor")
    val languageColor: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("url")
    val url: String
)