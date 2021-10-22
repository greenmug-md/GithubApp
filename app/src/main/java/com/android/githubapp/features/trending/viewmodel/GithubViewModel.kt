package com.android.githubapp.features.trending.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.githubapp.api.GithubApi
import com.android.githubapp.model.GithubProfileItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel  @Inject constructor(
    api: GithubApi
) : ViewModel() {

    private val gitLiveData = MutableLiveData<List<GithubProfileItem>>()
    val gitData : LiveData<List<GithubProfileItem>> = gitLiveData

    init{
        viewModelScope.launch {
            val profiles  = api.getAllProfiles()
            gitLiveData.postValue(profiles)
        }
    }

}