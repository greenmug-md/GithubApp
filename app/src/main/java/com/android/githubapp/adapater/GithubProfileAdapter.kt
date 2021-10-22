package com.android.githubapp.adapater

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.githubapp.databinding.FragmentGithubItemBinding
import com.android.githubapp.model.GithubProfileItem
import com.bumptech.glide.Glide

class GithubProfileAdapter : ListAdapter<GithubProfileItem, GithubProfileAdapter.GithubViewHolder>(ListItemComparator())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val binding =
            FragmentGithubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubViewHolder(binding)
    }


    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class GithubViewHolder(private val binding: FragmentGithubItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: GithubProfileItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(profile.avatar)
                    .into(image)

                name.text = profile.name
                desc.text = profile.description
            }
        }
    }

    class ListItemComparator : DiffUtil.ItemCallback<GithubProfileItem>() {
        override fun areItemsTheSame(oldItem: GithubProfileItem, newItem: GithubProfileItem) =
            oldItem.author == newItem.author

        override fun areContentsTheSame(oldItem: GithubProfileItem, newItem: GithubProfileItem) =
            oldItem == newItem
    }
}