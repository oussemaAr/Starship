package io.studio.demoapp.data

import io.studio.demoapp.domain.AppRepository
import io.studio.demoapp.domain.model.StarShip
import io.studio.demoapp.toIntOrZero

class AppRepositoryImpl
    (private val service: AppService) : AppRepository {

    override suspend fun fetchStarShip(maxPassengers: Int): List<StarShip> {
        val apiResult = service.fetchStarship()
        val result = mutableListOf<StarShip>()
        return apiResult.results.filter { startShipDetailsApiModel ->
            startShipDetailsApiModel.passengers.toIntOrZero() < maxPassengers
        }.map { starship ->

            val pilots = mutableListOf<String>()

            starship.pilots.forEach { pilotUrl ->
                val pilot = service.fetchPilotById(pilotUrl)
                pilots.add(pilot.name)
            }
            StarShip(
                starship.name,
                pilots,
                starship.crew,
                starship.starshipClass
            )
        }.toCollection(result)
    }

}