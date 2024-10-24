package com.a.technicaltest.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.a.technicaltest.databinding.FragmentMarketDetailBinding

internal class MarketDetailsFragment : Fragment() {
    private val viewModel by viewModels<MarketDetailViewModel>()
    private var binding: FragmentMarketDetailBinding? = null
    private val args: MarketDetailsFragmentArgs by navArgs()

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
            MarketDetailScreen(viewModel)
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setMarket(args.market)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
