package com.example.repositories.feature.repositories_list.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.repositories.common.utils.DefaultDiffCallback
import com.example.repositories.databinding.ItemRepositoriesBinding
import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import com.squareup.picasso.Picasso

class RepositoriesAdapter : ListAdapter<RepositoriesModel, RepositoriesAdapter.ViewHolder>(
    DefaultDiffCallback<RepositoriesModel>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRepositoriesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemRepositoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repositoriesItem: RepositoriesModel) {
            with(binding) {
                repoNameTextView.text = repositoriesItem.name
                repoDescriptionTextView.text = repositoriesItem.description
                repositoriesLanguageTextView.text = repositoriesItem.language
                chipStar.text = repositoriesItem.stargazersCount.toString()

                Picasso.with(itemView.context)
                    .load(repositoriesItem.owner.avatarURL)
                    .fit()
                    .into(ownerImageView)
            }
        }
    }
}