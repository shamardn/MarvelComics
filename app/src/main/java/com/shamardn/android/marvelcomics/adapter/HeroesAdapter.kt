package com.shamardn.android.marvelcomics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHero
import com.shamardn.android.marvelcomics.databinding.ItemHeroBinding

class HeroesAdapter(private var heroesList: List<MarvelHero>, private val listener: HeroesInteractionListener): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        return HeroesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val currentItem = heroesList[position]
        holder.binding.item = currentItem
        holder.binding.listener = listener

    }

    fun setItems(newList: List<MarvelHero>) {
        heroesList = newList
    }

    override fun getItemCount() = heroesList.size

    class HeroesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemHeroBinding.bind(itemView)
    }
}

interface HeroesInteractionListener{
    fun onClickHero(hero: MarvelHero)
}