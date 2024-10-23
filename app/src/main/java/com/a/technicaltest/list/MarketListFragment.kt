package com.a.technicaltest.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.a.technicaltest.R
import com.a.technicaltest.databinding.FragmentMarketListBinding
import com.a.technicaltest.list.MarketListEvent.ShowMarketDetail

internal class MarketListFragment : Fragment() {
    private val viewModel by viewModels<MarketListViewModel>()
    private var binding: FragmentMarketListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        FragmentMarketListBinding.inflate(inflater, container, false).let {
            binding = it
            initBinding()
            it.root
        }

    private fun initBinding() {
        binding?.recyclerView?.adapter = MarketListRecyclerViewAdapter(viewModel::onItemClick)

        viewModel.markets.observe(viewLifecycleOwner) { markets ->
            (binding?.recyclerView?.adapter as? MarketListRecyclerViewAdapter)?.data = markets
        }

        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                is ShowMarketDetail -> showMarketDetail(event)
            }
        }
    }

    @Suppress("UnusedParameter")
    private fun showMarketDetail(event: ShowMarketDetail) {
        findNavController().navigate(R.id.action_marketListFragment_to_marketDetailFragment)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
