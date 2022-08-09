package com.example.repositories.feature.repositories_list.presentation

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.repositories.databinding.FragmentRepositoriesListBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.repositories.R
import com.example.repositories.common.extensions.hideKeyboard
import com.example.repositories.feature.repositories_list.domain.model.RepositoriesModel
import com.example.repositories.feature.repositories_list.presentation.adapter.RepositoriesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoriesListFragment : Fragment(), SearchView.OnQueryTextListener {
    private val binding by lazy { FragmentRepositoriesListBinding.inflate(layoutInflater) }
    private val viewModel: RepositoriesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        observerState()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { viewModel.getRepositories(it) }
        binding.root.hideKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e(TAG, "onQueryTextChange: $newText")
        return false
    }

    companion object {
        private const val TAG = "TAG"
    }

    private fun observerState() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is RepositoriesViewState.Loading ->
                    binding.loadingProgressBar.isVisible = true
                is RepositoriesViewState.Success -> {
                    handleRecyclerView(state.repositoriesList)
                    binding.loadingProgressBar.isGone = true
                }
                is RepositoriesViewState.Error -> {
                    Toast.makeText(context, state.messageError, Toast.LENGTH_SHORT).show()
                    binding.loadingProgressBar.isGone = true
                }
            }
        }
    }

    private fun handleRecyclerView(list: List<RepositoriesModel>) {
        val repositoriesAdapter = RepositoriesAdapter()
        repositoriesAdapter.submitList(list)
        binding.repositoriesRecyclerView.adapter = repositoriesAdapter
    }
}