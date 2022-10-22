package io.studio.demoapp.domain.model

import androidx.recyclerview.widget.DiffUtil

data class StarShip(
    val name: String,
    val pilots: List<String>,
    val maxCrew: String,
    val startShipClass: String
)

object StarShipDiffUtils : DiffUtil.ItemCallback<StarShip>() {
    override fun areItemsTheSame(oldItem: StarShip, newItem: StarShip) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: StarShip, newItem: StarShip) = oldItem == newItem

}