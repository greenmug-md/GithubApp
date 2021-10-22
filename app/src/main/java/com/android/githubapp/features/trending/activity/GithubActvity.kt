package com.android.githubapp.features.trending.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.githubapp.R
import dagger.hilt.android.AndroidEntryPoint

import com.android.githubapp.features.trending.fragment.GithubFragment


@AndroidEntryPoint
class GithubActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_profile)
    }
}