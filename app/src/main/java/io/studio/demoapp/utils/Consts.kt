package io.studio.demoapp



const val BASE_URL ="https://swapi.dev"
const val STARSHIPS_ENDPOINT = "api/starships"
const val PILOT_ENDPOINT = "api/people"

fun String.toIntOrZero(): Int = this.toIntOrNull() ?: 0
