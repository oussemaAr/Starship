package io.studio.demoapp.data

import io.studio.demoapp.STARSHIPS_ENDPOINT
import io.studio.demoapp.data.model.pilot.PilotApiModel
import io.studio.demoapp.data.model.starship.StarShipApiModel
import retrofit2.http.GET
import retrofit2.http.Url

interface AppService {

    @GET(STARSHIPS_ENDPOINT)
    suspend fun fetchStarship(): StarShipApiModel

    @GET
    suspend fun fetchPilotById(@Url fullUrl: String): PilotApiModel

}