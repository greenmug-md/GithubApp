package com.android.githubapp.features.trending.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.githubapp.R
import com.android.githubapp.databinding.FragmentGithubItemBinding
import com.android.githubapp.features.trending.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubFragment : Fragment() {

    private var githubProfileBinding: FragmentGithubItemBinding? = null
    private val githubViewModel : GithubViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        githubProfileBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_github_item, container, false)
        return githubProfileBinding?.root
    }

    override fun onResume() {
        super.onResume()

    }

    companion object {
        const val TAG = "GithubFragment"
    }
}