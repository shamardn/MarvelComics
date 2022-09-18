package com.shamardn.android.marvelcomics.ui.home

import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.shamardn.android.marvelcomics.HeroesAdapter
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.base.BaseFragment
import com.shamardn.android.marvelcomics.databinding.FragmentHomeBinding
import com.shamardn.android.marvelcomics.utils.ClickEvent

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutIdFragment = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java
    lateinit var heroesAdapter: HeroesAdapter
    override fun setup() {

        heroesAdapter = HeroesAdapter(mutableListOf(), viewModel)
        binding.homeRecycler.adapter = heroesAdapter

        viewModel.character.observe(this){
            when(it){
                is ClickEvent.OnNavigateToDetailsFragment -> {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it.hero)
                  findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                }
            }
        }
    }
}