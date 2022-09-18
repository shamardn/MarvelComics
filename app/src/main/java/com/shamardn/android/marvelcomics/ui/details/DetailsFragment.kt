package com.shamardn.android.marvelcomics.ui.details

import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.shamardn.android.marvelcomics.R
import com.shamardn.android.marvelcomics.base.BaseFragment
import com.shamardn.android.marvelcomics.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {
    val args : DetailsFragmentArgs by navArgs()
    override val layoutIdFragment = R.layout.fragment_details
    override val viewModelClass = DetailsViewModel::class.java
    override fun setup() {
        binding.icBack.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }

//        if (args.heroData != null){
//            binding.textNameDetail.text = args.heroData?.name
//            binding.textDescriptionDetail.text = args.heroData?.description
//            val path = args.heroData?.thumbnail?.path + "." + args.heroData?.thumbnail?.extension
//            Glide.with(this).load(path).into(binding.imageDetail)
//        }
    }
}