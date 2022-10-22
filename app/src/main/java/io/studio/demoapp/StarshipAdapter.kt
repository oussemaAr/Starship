package io.studio.demoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import io.studio.demoapp.StarshipAdapter.StarShipViewHolder
import io.studio.demoapp.databinding.StarShipItemViewBinding
import io.studio.demoapp.domain.model.StarShip
import io.studio.demoapp.domain.model.StarShipDiffUtils

class StarshipAdapter : ListAdapter<StarShip, StarShipViewHolder>(StarShipDiffUtils) {


    inner class StarShipViewHolder(val binding: StarShipItemViewBinding) :
        ViewHolder(binding.root) {

        fun bind(starShip: StarShip) {
            binding.name.text = starShip.name
            binding.maxCrew.text = starShip.maxCrew
            binding.pilots.text = starShip.pilots.joinToString(",")
            binding.startshipClass.text = starShip.startShipClass
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarShipViewHolder {
        val binding =
            StarShipItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StarShipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StarShipViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}