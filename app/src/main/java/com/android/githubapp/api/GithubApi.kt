package com.android.githubapp.api

import com.android.githubapp.model.GithubProfileItem
import retrofit2.http.GET

interface GithubApi {

    @GET("v3/7ef86b70-f1a8-40ab-854c-5d679cd51cd4")
    suspend fun getAllProfiles():  List<GithubProfileItem>
}