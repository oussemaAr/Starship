package io.studio.demoapp.domain

import io.studio.demoapp.domain.model.StarShip

interface AppRepository {

    suspend fun fetchStarShip(maxPassengers: Int): List<StarShip>

}