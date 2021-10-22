package com.android.githubapp.di

import com.android.githubapp.api.GithubApi
import com.android.githubapp.utilities.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit() : GithubApi {
        return ApiClient.getRetrofitClient(Constants.BASE_URL)
            .create(GithubApi::class.java)
    }
}