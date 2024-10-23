package com.a.technicaltest.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a.technicaltest.data.Market
import com.a.technicaltest.databinding.ItemMarketBinding

internal class MarketListRecyclerViewAdapter(
    private val onItemClick: (Market) -> Unit,
) : RecyclerView.Adapter<MarketListRecyclerViewAdapter.MarketItemViewHolder>() {
    var data: List<Market> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MarketItemViewHolder {
        val binding = ItemMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarketItemViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(
        holder: MarketItemViewHolder,
        position: Int,
    ) {
        data.getOrNull(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = data.size

    class MarketItemViewHolder(
        private val binding: ItemMarketBinding,
        private val onItemClick: (Market) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Market) {
            binding.name.run {
                text = item.companyName
                setOnClickListener { onItemClick.invoke(item) }
            }
        }
    }
}
