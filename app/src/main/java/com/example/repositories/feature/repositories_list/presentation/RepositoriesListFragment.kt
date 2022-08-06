package com.example.repositories.feature.repositories_list.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.repositories.databinding.FragmentRepositoriesListBinding

class RepositoriesListFragment : Fragment() {

    private val binding by lazy { FragmentRepositoriesListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}