package com.shamardn.android.marvelcomics.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shamardn.android.marvelcomics.HeroesAdapter
import com.shamardn.android.marvelcomics.data.State
import com.shamardn.android.marvelcomics.data.model.hero.MarvelHero

@BindingAdapter(value = ["app:showOnSuccess"])
fun <T> showOnSuccess(view: View, state: State<T>?) {
    view.isVisible = (state is State.Success)
}

@BindingAdapter(value = ["app:showOnError"])
fun <T> showOnError(view: View, state: State<T>?) {
    view.isVisible = (state is State.Error)
}


@BindingAdapter(value = ["app:showOnLoading"])
fun <T> showOnLoading(view: View, state: State<T>?) {
    view.isVisible = (state is State.Loading)
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view:ImageView, url: String?){
    val extension = "jpg"
    Glide.with(view).load("$url.$extension").centerCrop().into(view)
}

@BindingAdapter(value = ["app:items"])
    fun setRecyclerItems(view: RecyclerView, items: List<MarvelHero>?){
    if (items != null){
        (view.adapter as HeroesAdapter).setItems(items)
    }else {
        (view.adapter as HeroesAdapter).setItems(emptyList())
    }

}