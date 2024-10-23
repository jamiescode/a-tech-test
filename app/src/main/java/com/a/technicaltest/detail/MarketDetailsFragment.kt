package com.a.technicaltest.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a.technicaltest.databinding.FragmentMarketDetailBinding

internal class MarketDetailsFragment : Fragment() {
    private var binding: FragmentMarketDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        FragmentMarketDetailBinding.inflate(inflater, container, false).let {
            binding = it
            initBinding()
            it.root
        }

    private fun initBinding() {
        val composeView = binding?.root
        composeView?.setContent {
            MarketDetailScreen()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
